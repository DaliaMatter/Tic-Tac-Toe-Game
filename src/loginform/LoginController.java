package loginform;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;

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

}
