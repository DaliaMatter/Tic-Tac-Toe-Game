/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojectgui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author dell2
 */
public class FXMLDocumentControllerChoice implements Initializable {

    @FXML
    public AnchorPane anchorPane;
    
    Vector<Text> arrText;
    @FXML
    public Label label;
    
    @FXML
    public Button btn1, btn2, btn3;
    @FXML
    public GridPane myGrade;
    @FXML
    public Button easy;
    @FXML
    public Button hard;

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
        String st = " -fx-fill:white; -fx-font-size:16px; -fx-font-family:Arial; -fx-text-align:center;";
       /* arrText = new Vector<Text>();

        Text label2 = new Text("Label");
        label2.setStyle(st);
        Text label3 = new Text("Label");
        label3.setStyle(st);
        Text label4 = new Text("Label");
        label4.setStyle(st);

        Text label5 = new Text("Label");
        label5.setStyle(st);
        Text label6 = new Text("Label");
        label6.setStyle(st);
        Text label7 = new Text("Label");
        label7.setStyle(st);

        Text label8 = new Text("Label");
        label8.setStyle(st);
        Text label9 = new Text("Label");
        label9.setStyle(st);
        Text label10 = new Text("Label");
        Text label11 = new Text("Label");
        Text label12 = new Text("Label");

        Label label13 = new Label("Label");
        Label label14 = new Label("Label");
*/
        for (int i = 1; i < 10; i++) {
            Text label = new Text("Label");
            label.setStyle(st);
            myGrade.add(label, 0, i);
            Text labe = new Text("Label");
            labe.setStyle(st);
            myGrade.add(labe, 1, i);
            Button lab = new Button("Label");
            //lab.setStyle(st);
            lab.setId(i+"");
            lab.setOnAction(e->{System.out.println(lab.getId());});
            myGrade.add(lab, 2, i);
        }
        
  /*      myGrade.add(label3, 1, 3);
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
        System.out.println(myGrade.getChildren().get(0));*/
    }

    @FXML
    public void easyAI(ActionEvent actionevent) {
        Parent root;
        Stage register_stage;
        FXMLLoader fxmlLoader;
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            root = (Parent) fxmlLoader.load();

            Scene scene = new Scene(root);
            ((FXMLDocumentController) fxmlLoader.getController()).setLevel("easy");
            register_stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();

            register_stage.setScene(scene);
            register_stage.setResizable(false);
            register_stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void hardAI(ActionEvent actionevent) {
        Parent root;
        Stage register_stage;
        FXMLLoader fxmlLoader;
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            root = (Parent) fxmlLoader.load();

            Scene scene = new Scene(root);
            ((FXMLDocumentController) fxmlLoader.getController()).setLevel("hard");
            register_stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();

            register_stage.setScene(scene);
            register_stage.setResizable(false);
            register_stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void closeAction(ActionEvent actionevent) {
        System.exit(0);
    }

    @FXML
    public void minimizeAction(ActionEvent actionevent) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setIconified(true);
    }

}
