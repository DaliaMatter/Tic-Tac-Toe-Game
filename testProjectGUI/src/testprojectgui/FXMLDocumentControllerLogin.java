package testprojectgui;

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
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Yahya
 */
public class FXMLDocumentControllerLogin implements Initializable {

    @FXML
    public AnchorPane anchorPane;
    @FXML
    private TextField tf_username;
    @FXML
    private Button btn_login;
    @FXML
    private PasswordField tf_password;
    @FXML
    private Hyperlink registerLink;

    public Stage myStage;
    public Scene myScene;

    public void setStage(Stage stage, Scene scene) {
        myStage = stage;
        myScene = scene;
    }

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
            root = FXMLLoader.load(getClass().getResource("FXMLDocumentRegister.fxml"));
            Scene scene = new Scene(root);
            register_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            register_stage.setScene(scene);
            register_stage.setResizable(false);
            register_stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
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
