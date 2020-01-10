/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojectgui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author dell2
 */
public class alert {
    public static void display (String title,String mess)
    {
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(200);
        window.setHeight(200);
        Label l1=new Label();
        l1.setText(mess);
        Button btn=new Button("close");
        btn.setOnAction(e->window.close());
        VBox lay=new VBox(10);
        lay.getChildren().addAll(l1,btn);
        lay.setAlignment(Pos.CENTER);
        Scene scene=new Scene(lay);
        
        window.setScene(scene);
        
        window.initStyle(StageStyle.UNDECORATED);
        scene.setFill(Color.TRANSPARENT);
        window.initStyle(StageStyle.TRANSPARENT);
        window.showAndWait();
     
    }
    
}
