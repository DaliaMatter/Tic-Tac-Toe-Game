package loginform;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Yahya
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField tf_username;
    @FXML
    private JFXButton btn_login;
    @FXML
    private JFXPasswordField tf_password;
    @FXML
    private Hyperlink registerLink;

    @FXML
    void handleLoginButton(ActionEvent event) {
        if (tf_password.getText().isEmpty()) {
            tf_password.promptTextProperty().setValue("You must enter your Password ");
        }
    }

    @FXML
    void resetNameField(MouseEvent event) {
        tf_username.promptTextProperty().setValue("User Name");
    }

    @FXML
    void validateName(MouseEvent event) {
        tf_password.promptTextProperty().setValue("Password");
        if (tf_username.getText().isEmpty()) {
            tf_username.promptTextProperty().setValue("You must enter your Username");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleRegisterLink(ActionEvent event) {
        Parent root;
        Stage register_stage;
        try {
            root = FXMLLoader.load(getClass().getResource("../registerform/register_form.fxml"));
            Scene scene = new Scene(root);
            register_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            register_stage.setScene(scene);
            register_stage.initStyle(StageStyle.UNDECORATED);
            register_stage.setResizable(false);
            register_stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
