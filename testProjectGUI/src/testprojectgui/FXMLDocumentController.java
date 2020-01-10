/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojectgui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author dell2
 */
public class FXMLDocumentController implements Initializable {

    private static Game game;
    private static String[] board;
    private static SinglePlayer AI;
    private boolean win;
    private boolean draw;
    private char turn;
    private int pos;
    private boolean AIFlag;
    private boolean AITurn;

    @FXML
    public Label label;
    @FXML
    public Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    @FXML
    public GridPane chatList;

    public Stage myStage;
    public Scene myScene;

    public void setStage(Stage stage, Scene scene) {
        myStage = stage;
        myScene = scene;
    }

    @FXML
    public void clickPOS0(ActionEvent event) {
        if (turn == 'X') {
            btn0.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
        } else {
            btn0.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
        }
        selectPosition(0);
        if (AIFlag == true && win != true) {
            pcPositions();
        }
    }

    @FXML
    public void clickPOS1(ActionEvent event
    ) {
        if (turn == 'X') {
            btn1.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
        } else {
            btn1.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
        }
        selectPosition(1);
        if (AIFlag == true && win != true) {
            pcPositions();
        }

    }

    @FXML
    public void clickPOS2(ActionEvent event
    ) {
        if (turn == 'X') {
            btn2.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
        } else {
            btn2.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
        }
        selectPosition(2);
        if (AIFlag == true && win != true) {
            pcPositions();
        }

    }

    @FXML
    public void clickPOS3(ActionEvent event
    ) {
        if (turn == 'X') {
            btn3.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
        } else {
            btn3.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
        }
        selectPosition(3);
        if (AIFlag == true && win != true) {
            pcPositions();
        }

    }

    @FXML
    public void clickPOS4(ActionEvent event
    ) {
        if (turn == 'X') {
            btn4.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
        } else {
            btn4.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
        }
        selectPosition(4);
        if (AIFlag == true && win != true) {
            pcPositions();
        }

    }

    @FXML
    public void clickPOS5(ActionEvent event
    ) {
        if (turn == 'X') {
            btn5.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
        } else {
            btn5.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
        }
        selectPosition(5);
        if (AIFlag == true && win != true) {
            pcPositions();
        }

    }

    @FXML
    public void clickPOS6(ActionEvent event
    ) {
        if (turn == 'X') {
            btn6.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
        } else {
            btn6.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
        }
        selectPosition(6);
        if (AIFlag == true && win != true) {
            pcPositions();
        }

    }

    @FXML
    public void clickPOS7(ActionEvent event
    ) {
        if (turn == 'X') {
            btn7.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
        } else {
            btn7.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
        }
        selectPosition(7);
        if (AIFlag == true && win != true) {
            pcPositions();
        }

    }

    @FXML
    public void clickPOS8(ActionEvent event) {

        if (turn == 'X') {
            btn8.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
        } else {
            btn8.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
        }
        selectPosition(8);
        if (AIFlag == true && win != true) {
            pcPositions();
        }

    }

    private void selectPosition(int position) {
        game.board.emptyBoard[position].setSymbol(turn);
        if (AITurn != true) {
            if (turn == 'X') {
                turn = 'O';
            } else {
                turn = 'X';
            }
            AITurn = true;
        } else {
            AITurn = false;
        }
        game.checkWinner();
        win = game.winFlag;
        draw = game.drawFlag;
        if (win) {
            System.out.println("Winer");
        } else if (draw) {
            System.out.println("Draw");
        }

    }

    private void pcPositions() {
        pos = AI.hardLevel(game);
        selectPosition(pos);
        switch (pos) {
            case 0:
                if (turn == 'X') {
                    btn0.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
                } else {
                    btn0.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
                }
                break;
            case 1:
                if (turn == 'X') {
                    btn1.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
                } else {
                    btn1.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
                }
                break;
            case 2:
                if (turn == 'X') {
                    btn2.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
                } else {
                    btn2.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
                }
                break;
            case 3:
                if (turn == 'X') {
                    btn3.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
                } else {
                    btn3.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
                }
                break;
            case 4:
                if (turn == 'X') {
                    btn4.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
                } else {
                    btn4.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
                }
                break;
            case 5:
                if (turn == 'X') {
                    btn5.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
                } else {
                    btn5.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
                }
                break;
            case 6:
                if (turn == 'X') {
                    btn6.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
                } else {
                    btn6.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
                }
                break;
            case 7:
                if (turn == 'X') {
                    btn7.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
                } else {
                    btn7.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
                }
                break;
            case 8:
                if (turn == 'X') {
                    btn8.setStyle("-fx-background-image:url('/image/black-x-png-32.png')");
                } else {
                    btn8.setStyle("-fx-background-image:url('/image/favicon-png-2.png')");
                }
                break;
        }
        if (turn == 'X') {
            turn = 'O';
        } else {
            turn = 'X';
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = new Game();
        AI = new SinglePlayer();
        win = false;
        draw = false;
        turn = 'X';
        AIFlag = true;
        AITurn = false;

        Label ll = new Label("name");
        chatList.add(new TextArea(""), 0, 0);
        chatList.add(new TextArea("name"), 0, 1);
        chatList.add(new TextArea("name"), 0, 2);
        chatList.add(new TextArea("name"), 0, 3);
        chatList.add(new TextArea("namnnfzfghjkljhgfdsfghje"), 0, 4);
        chatList.add(new TextArea("name"), 0, 5);
        chatList.add(new TextArea("namlkjhgfdg,j.ke"), 0, 6);
        chatList.add(new TextArea("name"), 0, 7);
        chatList.add(new TextArea("name"), 0, 8);
        chatList.add(new TextArea("name"), 0, 9);
        chatList.add(new TextArea("name"), 0, 10);
        chatList.add(new TextArea("name"), 0, 11);
        chatList.add(new TextArea("name"), 0, 12);
        chatList.add(new TextArea("name"), 0, 13);
        chatList.add(new TextArea("name"), 0, 14);
        chatList.add(new TextArea("name"), 0, 15);
        chatList.add(new TextArea("name"), 0, 16);
        chatList.add(new TextArea("name"), 0, 17);
        chatList.add(new TextArea("name"), 0, 18);
        chatList.add(new TextArea("name"), 0, 19);
    }

    @FXML
    private void closeAction(ActionEvent actionevent) {
        System.exit(0);
    }

}
