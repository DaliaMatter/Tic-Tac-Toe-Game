/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

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

    private ServerSocket localServer;
    private Socket client;
    private Boolean serverStart;
    @FXML
    private Button stop, start;

    @FXML
    private Label label;

    @FXML
    private void buttonEnd() {
        serverStart = false;
    }

    @FXML
    private void closeAction(ActionEvent actionevent) {

    }

    @FXML
    private void buttonStart(ActionEvent actionevent) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}