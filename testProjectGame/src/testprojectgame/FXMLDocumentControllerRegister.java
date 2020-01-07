/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojectgame;

import java.net.*;
import java.util.*;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.input.*;

/**
 *
 * @author Yahya
 */
public class FXMLDocumentControllerRegister implements Initializable {

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField tf_password_1;

    @FXML
    private PasswordField tf_password_2;

    @FXML
    private Button btn_register;
    
    @FXML
    private RadioButton male;
    
    @FXML
    private RadioButton female;
    
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

    @FXML
    private void checkPassword(ActionEvent  event) {
//        System.out.println(tf_password_1.getText().toString());
//        System.out.println(tf_password_2.getText().toString());
        if (!tf_password_1.getText().equals(tf_password_2.getText()) ) {
            tf_password_2.promptTextProperty().setValue("The two passwords are not the same !!");
        }
       
    }
    @FXML
    private void radioButtonMaleHandler(ActionEvent  event)
    {
        if(female.isSelected())
        {
            female.setSelected(false);
        }
    }
    @FXML
    private void radioButtonFemaleHandler(ActionEvent  event)
    {
        if(male.isSelected())
        {
            male.setSelected(false);
        }
    }
    @FXML
    private void closeAction(ActionEvent actionevent) {
        System.exit(0);
    }

}
