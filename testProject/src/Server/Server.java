package Server;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell2
 */
public class Server {
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    private ServerSocket localServer;
    private Socket client;

  

    public Server() {
        
        try {
            localServer = new ServerSocket(5205);
            while (true) {
                this.client = this.localServer.accept();
                new ChatHandler(this.client);
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }
    public void shutDown()
    {
    }

    static class ChatHandler extends Thread {

        public static Vector<ChatHandler> clientsVec = new Vector<ChatHandler>();
        public static Vector<String> clientsSessionVec = new Vector<String>();
        private static Vector<String> users = new Vector<String>();
        private String name;
        DataInputStream dataRecived;
        PrintStream dataToSend;

        public ChatHandler(Socket ClientSoc) {
            try {
                dataRecived = new DataInputStream(ClientSoc.getInputStream());
                dataToSend = new PrintStream(ClientSoc.getOutputStream());
                //sendMessageToAll("4,user :  has logged in...");
                clientsVec.addElement(this);
                start();
            } catch (Exception e) {
                e.getMessage();
            }
        }

        @Override
        public void run() {

            while (true) {
                try {

                    String msg = dataRecived.readLine();
                    String msgCode = msg.split(",")[0];
                    System.out.println(msgCode);
                    if (msgCode.matches("0")) {
                        //connection recived...
                        String name = msg.split(",")[1].split("=")[1];
                        users.add(name);
                        System.out.println("in connection stmt...");
                        notifyAllClients();
                        sendNotficationToAllUsers(name);
                    } else if (msgCode.matches("1")) {
                        //request recived...
                        String name = msg.split(",")[1].split("=")[1];
                        String rival = msg.split(",")[2].split("=")[1];
                        if (playerInSession(rival) == false && playerInSession(name) == false) {
                            sendRequestToOtherClient(name, rival);
                        } else if (playerInSession(rival)) {
                            System.out.println("in rival session case...");
                            sendMsgToClient(name, "1.3," + rival + " is currnetlly in a session with another player...");
                        } else if (playerInSession(name)) {
                            System.out.println("in player session case...");
                            sendMsgToClient(name, "1.3,you are already in a session");
                        }
                    } else if (msgCode.matches("1.1") || msgCode.matches("1.2")) {
                        // response about request from rival to player...
                        System.out.println("in code 1.1...");
                        name = msg.split(",")[2].split("=")[1];
                        String rival = msg.split(",")[1].split("=")[1];

                        System.out.println("player " + name + " rival " + rival);
                        rsponseBackToPlayer(msgCode, name, rival);
                    } else if (msgCode.matches("3")) {
                        //send msg to a client
                        String name = msg.split(",")[1].split("=")[1];
                        msg = msg.split(",")[2];
                        System.out.println(msg);
                        for (int i = 0; i < clientsSessionVec.size(); i++) {
                            String sess1 = clientsSessionVec.elementAt(i).split(":")[0];
                            String sess2 = clientsSessionVec.elementAt(i).split(":")[1];
                            if (sess1.matches(name) || sess2.matches(name)) {
                                System.out.println("session between " + sess1 + " and " + sess2 + " found...");
                                sendMsgToOtherClient(msg, sess1, sess2);
                                break;
                            }
                        }
                    } else if (msgCode.matches("5")) {
                        //send msg to a client
                        String userWantClose = msg.split(",")[1].split("=")[1];
                        System.out.println("close" + msg);
                        int i = 0;
                        for (String name : users) {
                            if (userWantClose.equals(name)) {
                                break;
                            }
                            i++;
                        }
                        clientsVec.elementAt(i).dataToSend.println("6,ack=ok");
                        users.remove(i);
                        clientsVec.remove(i);
                        
                        for (ChatHandler clientSoc : clientsVec) {
                            clientSoc.dataToSend.println("7,close=" + msg);
                        }

                    } else {
                        sendMessageToAll(msg);
                    }

                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }

        void sendMessageToAll(String ms) {
            for (ChatHandler clientSoc : clientsVec) {
                clientSoc.dataToSend.println(ms);
            }
        }

        void sendNotficationToAllUsers(String user) {
            for (int i = 0; i < users.size() - 1; i++) {

                clientsVec.elementAt(i).dataToSend.println("4,user : " + user + "  has logged in...");
            }
        }

        boolean playerInSession(String player) {
            System.out.println("in session checking function...");
            System.out.println("player is : " + player);

            for (int i = 0; i < clientsSessionVec.size(); i++) {
                String sess1 = clientsSessionVec.elementAt(i).split(":")[0];
                String sess2 = clientsSessionVec.elementAt(i).split(":")[1];
                System.out.println("s1 : " + sess1);
                System.out.println("s2 : " + sess2);

                if (sess1.matches(player) || sess2.matches(player)) {
                    System.out.println(player + " is in session...");
                    return true;
                }

                System.out.println("sessvec : " + clientsSessionVec.elementAt(i));
            }
            return false;
        }

        void sendMsgToOtherClient(String msg, String sess1, String sess2) {
            //used to handle chat between two players...
            int sess1Index = users.indexOf(sess1);
            int sess2Index = users.indexOf(sess2);
            System.out.println("inside sending function...");
            System.out.println("sess1: " + sess1Index);
            System.out.println("sess1: " + sess1);
            System.out.println("\nsess1: " + sess2Index);
            System.out.println("sess1: " + sess2);
            clientsVec.elementAt(sess1Index).dataToSend.println(msg);
            clientsVec.elementAt(sess2Index).dataToSend.println(msg);
        }

        void sendMsgToClient(String client, String msg) {
            //used to send a direct msg to a user...
            int clientIndex = users.indexOf(client);
            System.out.println("in sending method...");
            System.out.println(msg);
            System.out.println(client);
            clientsVec.elementAt(clientIndex).dataToSend.println(msg);
        }

        void sendRequestToOtherClient(String name, String rival) {
            int index = users.indexOf(rival);
            if (index != -1) {
                clientsVec.elementAt(index).dataToSend.println("1,name=" + name);
            }

        }

        void rsponseBackToPlayer(String code, String name, String rival) {

            int index = users.indexOf(name);
            if (index != -1) {
                if (code.matches("1.1")) {
                    // response back to player (accept)
                    System.out.println("in accept case...");
                    clientsVec.elementAt(index).dataToSend.println("1.1,rival=" + rival);
                    clientsSessionVec.add(name + ":" + rival);
                    System.out.println(clientsSessionVec);
                } else if (code.matches("1.2")) {
                    // response back to player (reject)
                    System.out.println("in reject case...");
                    clientsVec.elementAt(index).dataToSend.println("1.2,rival=" + rival);
                }
            }
        }

        void notifyAllClients() {
            String names = "";
            for (String name : users) {
                names += name + " ";
            }
            users.indexOf("ali");
            System.out.print("\n\n\n\n" + names);
            System.out.print(clientsVec.size());
            for (ChatHandler clientSoc : clientsVec) {
                clientSoc.dataToSend.println("0," + names);
            }

        }
    }
}
