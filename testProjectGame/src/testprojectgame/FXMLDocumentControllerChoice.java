/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojectgame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author dell2
 */
public class FXMLDocumentControllerChoice implements Initializable {

    @FXML
    public Label label;
    @FXML
    public Button btn1,btn2,btn3;

    public Stage myStage;
    public Scene myScene;

    public void setStage(Stage stage, Scene scene) {
        myStage = stage;
        myScene = scene;
    }

    @FXML
    public void changeImaage(ActionEvent event) {
       
     btn2.setStyle("-fx-background-image: url('favicon-png-2.png')");
     btn3.setStyle("-fx-background-image: url('black-x-png-32.png')");
     btn1.setStyle("-fx-background-image: url('black-x-png-32.png')");

            myStage.setScene(myScene);
            myStage.show();
            System.out.println("jj");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void closeAction(ActionEvent actionevent) {
        System.exit(0);
    }

}
