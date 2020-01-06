/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerform;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Yahya
 */
public class RegisterController implements Initializable {

    @FXML
    private JFXTextField tf_username;


    @FXML
    private JFXPasswordField tf_password_1;

    @FXML
    private JFXPasswordField tf_password_2;

    @FXML
    private JFXButton btn_register;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void resetNameField(MouseEvent event) {
        tf_username.promptTextProperty().setValue("User Name");
    }

    @FXML
    private void validateName(MouseEvent event) {
        tf_password_1.promptTextProperty().setValue("Password");
        if (tf_username.getText().isEmpty()) {
            tf_username.promptTextProperty().setValue("You must enter your Username");
        }
    }

    @FXML
    private void validatePasswordAndName(MouseEvent event) {
        tf_password_2.promptTextProperty().setValue("Confirm Password");
        if (tf_password_1.getText().isEmpty()) {
            tf_password_1.promptTextProperty().setValue("You must enter your Password");
        }
        if (tf_username.getText().isEmpty()) {
            tf_username.promptTextProperty().setValue("You must enter your Username");
        }
    }

//    @FXML
//    private void checkPassword(InputMethodEvent event) {
//        if(tf_password_1 != tf_password_2){
//            tf_password_2.promptTextProperty().setValue("They aren't the same !!");
//        }
//    }

}
