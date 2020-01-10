package chatroomclients;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane; 
import javax.swing.JTextArea; 
import javax.swing.JTextField; 

public class ChatRoomClients extends JFrame{
    
    private JTextArea ta = new JTextArea(5, 40);
    private JTextArea ta2 = new JTextArea(5, 40);
    private JScrollPane scroll = new JScrollPane(this.ta);
    private JTextField tf = new JTextField(30);
    private JButton okButton = new JButton("Send");

    private PrintStream dataToSend;
    private DataInputStream dataRecieved;
    private Socket localSocket;
    private String name;
    private String rival;
    
    public static void main(String[] args) {        
        new ChatRoomClients("ahmed");
    }
    
    public ChatRoomClients(String Name){
        try{
            this.localSocket = new Socket( "127.0.0.1", 5205);
            this.dataRecieved = new DataInputStream( localSocket.getInputStream());
            this.dataToSend = new PrintStream(localSocket.getOutputStream());
            this.name=Name;
            ChatRoomClients.this.dataToSend.println("0,name="+this.name);
        } catch(Exception e){
            e.printStackTrace();
        }
        
       this.setLayout( new FlowLayout() );
       this.scroll.setViewportView(this.ta);
       this.okButton.addActionListener(new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent ae){
               String msg = ChatRoomClients.this.tf.getText();
               if( !msg.equals("") ){
                    ChatRoomClients.this.dataToSend.println("3,name=ahmed,"+msg + "\n");
                    ChatRoomClients.this.tf.setText("");              
                }
               else {
                   Scanner sc = new Scanner(System.in); 
  
                   // String input 
                   System.out.println("choose your rival...");
                   String rival = sc.nextLine();
                   ChatRoomClients.this.dataToSend.println("1,name=ahmed,rival="+rival);
               }
            }
        });
       this.setTitle("ahmed");
       add(this.scroll);
       this.ta.setEditable(false);
       add(this.ta);
       add(this.tf);
       add(this.okButton);
       add(this.ta2);
       this.setSize(500, 500);
       this.setVisible(true);
       new Thread( new Runnable(){
           @Override
           public void run(){
               while(true){
                   try{
                       String msg = dataRecieved.readLine();
                       String msgCode=msg.split(",")[0];
                       System.out.println(msgCode);
                       if(msgCode.matches("0")){
                           String usersNames = msg.split(",")[1];
                           String usersArr[]=usersNames.split(" ");
                           String users="online players : \n\n";
                           for (int i =0;i<usersArr.length;i++){
                               if(usersArr[i].matches("ahmed"))
                                    continue;
                               users+=usersArr[i]+"\n";
                           }
//                         ChatRoomClients.this.ta2.setText("");
                           ChatRoomClients.this.ta2.setText(users);
                       }
                       else if(msgCode.matches("1")){
                           String user = msg.split(",")[1].split("=")[1];
                           System.out.println("you have a request from "+user);
                           
                           Scanner sc = new Scanner(System.in); 
  
                           // String input 
                           String ans = sc.nextLine();
                           
                           if (ans.matches("yes")){
                               System.out.println("you choosed yes...");
                               ChatRoomClients.this.dataToSend.println("1.1,name=ahmed,dest="+user);
                           }
                           else{
                               ChatRoomClients.this.dataToSend.println("1.2,name=ahmed,dest="+user);
                           }
                       }
                       
                       else if (msgCode.matches("1.1")){
                           String rival = msg.split(",")[1].split("=")[1];
                           System.out.println(rival+" has acepted your request...");
                       }
                       else if (msgCode.matches("1.2")){
                           String rival = msg.split(",")[1].split("=")[1];
                           System.out.println(rival+" has rejected your request...");
                       }
                       else if(msgCode.matches("1.3")){
                           System.out.println("inside msgCode 1.3");
                           String SplitedMsg =msg.split(",")[1];
                           System.out.println(SplitedMsg);
                       }
                       else if(msgCode.matches("4")){
                           String splitedMsg=msg.split(",")[1];
                           System.out.println(splitedMsg);
                       }
//                       else if (msgCode.matches("1.3")){
//                           //String rival = msg.split(",")[1].split("=")[1];
//                           System.out.println("in code 1.3 in client...");
//                           System.out.println(msg.split(",")[1]);
//                       }
                       else {
                           ChatRoomClients.this.ta.append(msg + "\n");
                       }
                       
                       
                   } catch( Exception e){
                       e.printStackTrace();
                   }
               }
           }
       }).start();
    }
}


