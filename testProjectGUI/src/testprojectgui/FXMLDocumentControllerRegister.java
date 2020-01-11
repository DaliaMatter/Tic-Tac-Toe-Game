/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojectgui;

import java.net.*;
import java.util.*;
import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Yahya
 */
public class FXMLDocumentControllerRegister implements Initializable {

    @FXML
    public AnchorPane anchorPane;
    @FXML
    public TextField tf_username;

    @FXML
    public PasswordField tf_password_1;

    @FXML
    public PasswordField tf_password_2;

    @FXML
    public Button btn_register;

    @FXML
    public RadioButton male;

    @FXML
    public RadioButton female;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void resetNameField(MouseEvent event) {
        tf_username.promptTextProperty().setValue("User Name");
    }

    @FXML
    public void validateName(MouseEvent event) {
        tf_password_1.promptTextProperty().setValue("Password");
        if (tf_username.getText().isEmpty()) {
            tf_username.promptTextProperty().setValue("You must enter your Username");
        }
    }

    @FXML
    public void validatePasswordAndName(MouseEvent event) {
        tf_password_2.promptTextProperty().setValue("Confirm Password");
        if (tf_password_1.getText().isEmpty()) {
            tf_password_1.promptTextProperty().setValue("You must enter your Password");
        }
        if (tf_username.getText().isEmpty()) {
            tf_username.promptTextProperty().setValue("You must enter your Username");
        }
    }

    @FXML
    public void checkPassword(ActionEvent event) {
//        System.out.println(tf_password_1.getText().toString());
//        System.out.println(tf_password_2.getText().toString());
        if (!tf_password_1.getText().equals(tf_password_2.getText())) {
            tf_password_2.promptTextProperty().setValue("The two passwords are not the same !!");
        }

    }

    @FXML
    public void radioButtonMaleHandler(ActionEvent event) {
        if (female.isSelected()) {
            female.setSelected(false);
        }
    }

    @FXML
    public void radioButtonFemaleHandler(ActionEvent event) {
        if (male.isSelected()) {
            male.setSelected(false);
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
