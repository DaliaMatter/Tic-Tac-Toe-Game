/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import ChatRoomClients.ChatRoomClients;
import Server.Server;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author dell2
 */
public class FXMLDocumentController implements Initializable {

    static public Boolean startS;
    private Boolean serverStart;
    private Thread tt;
    private Server ss;
    @FXML
    private Button stop, start;

    @FXML
    private Label label;

    @FXML
    private void buttonEnd(ActionEvent actionevent) {
        startS = false;

        System.out.println("stop closeAction");
    }

    @FXML
    private void closeAction(ActionEvent actionevent) {
        System.out.println("stop closeAction");

    }

    @FXML
    private void buttonStart(ActionEvent actionevent) {
        startS = true;
        tt = new Thread(new Runnable() {
            public void stop() {
                System.out.println("Runnable is stopping");
                try {
                    ss.shutDown();
                    System.exit(0);
                } catch (Exception e) {
                    System.exit(-1);
                }
            }

            @Override
            public void run() {
                while (startS) {
                    ss = new Server();
                    if (!startS) {
                        System.out.println("break");
                        break;
                    }
                }

            }
        });
                        System.out.println("after loop");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
