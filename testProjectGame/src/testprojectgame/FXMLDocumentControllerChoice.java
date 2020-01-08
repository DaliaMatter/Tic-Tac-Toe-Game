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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author dell2
 */
public class FXMLDocumentControllerChoice implements Initializable {
    
    @FXML
    public Label label;
    @FXML
    public Button btn1, btn2, btn3;
    @FXML
    public GridPane myGrade;
    
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
        Label Label111 = new Label("Text Field");
        //col,row
        myGrade.add(Label111, 1, 1);
        Label label2 = new Label("Label");
        Label label3 = new Label("Label");
        Label label4 = new Label("Label");
        Label label5 = new Label("Label");
        Label label6 = new Label("Label");
        Label label7 = new Label("Label");
        Label label8 = new Label("Label");
        Label label9 = new Label("Label");
        Label label10 = new Label("Label");
        Label label11 = new Label("Label");
        Label label12 = new Label("Label");
        Label label13 = new Label("Label");
        Label label14 = new Label("Label");
        myGrade.add(label2, 1, 2);
        myGrade.add(label3, 1, 3);
        myGrade.add(label4, 1, 4);
        myGrade.add(label5, 1, 5);
        myGrade.add(label6, 1, 6);
        myGrade.add(label7, 1, 7);
        myGrade.add(label8, 1, 8);
        myGrade.add(label9, 1, 9);
        myGrade.add(label10, 1, 10);
        myGrade.add(label11, 1, 11);
        myGrade.add(label12, 1, 12);  
        myGrade.add(label13, 1, 13);
        myGrade.add(label14, 1, 14);

        
        System.out.println(myGrade.getChildren().get(0));
    }

    @FXML
    private void closeAction(ActionEvent actionevent) {
        System.exit(0);
    }
    
}
