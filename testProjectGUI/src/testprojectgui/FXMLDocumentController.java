/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprojectgui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author dell2
 */
public class FXMLDocumentController implements Initializable {

    public static Game game;
    public static String[] board;
    public static SinglePlayer AI;
    public boolean win;
    public boolean draw;
    public char turn;
    public int pos;
    public boolean AIFlag;
    public boolean AITurn;
    public String choseenLevel;

    @FXML
    public AnchorPane anchorPane;
    @FXML
    public Label label;
    @FXML
    public Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    @FXML
    public VBox ChatRoom;

    public Vector<TextArea> theChat;
    public Stage myStage;
    public Scene myScene;

    public void setLevel(String lev) {
        choseenLevel = lev;
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
            checkWin();
        }
    }

    @FXML
    public void clickPOS1(ActionEvent event) {
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
    public void clickPOS2(ActionEvent event) {
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
    public void clickPOS3(ActionEvent event) {
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
    public void clickPOS4(ActionEvent event) {
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
    public void clickPOS5(ActionEvent event) {
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
    public void clickPOS6(ActionEvent event) {
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
    public void clickPOS7(ActionEvent event) {
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

    public void selectPosition(int position) {
        game.board.emptyBoard[position].setSymbol(turn);
        if (AITurn != true && AIFlag != true) {
            checkWin();
            if (turn == 'X') {
                turn = 'O';
            } else {
                turn = 'X';
            }
        } else if (AITurn != true && AIFlag == true) {
            checkWin();
            if (turn == 'X') {
                turn = 'O';
            } else {
                turn = 'X';
            }
            AITurn = true;
        } else {
            AITurn = false;
        }

    }

    public void pcPositions() {
        switch (choseenLevel) {
            case "easy":
                pos = AI.easyLevel(game);
                break;
            case "hard":
                pos = AI.hardLevel(game);
                break;
            default:
                break;
        }
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
        checkWin();
        if (turn == 'X') {
            turn = 'O';
        } else {
            turn = 'X';
        }
    }

    public void checkWin() {
        game.checkWinner();
        win = game.winFlag;
        draw = game.drawFlag;
        if (win) {
            System.out.println("Winer");

            alert.display("Winer", turn + "is");

        } else if (draw) {
            System.out.println("Draw");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = new Game();
        AI = new SinglePlayer();
        win = false;
        draw = false;
        turn = 'X';
        AIFlag = false;
        AITurn = false;
        theChat = new Vector<>();
        theChat = new Vector<>();
        TextArea a = new TextArea("ldgfhdsnfcvxcvcxvcxvcxvcvxcvhjsdfmdsfsdfsdfsdf");
        a.setEditable(false);
        theChat.add(a);
        TextArea a1 = new TextArea("cvcxvcvvvxvcxvcvxcvxcvcxvxcvxcvxvx");
        a1.setEditable(false);
        //a1.setStyle("-fx-background-color:yellow;");
        theChat.add(a1);
        TextArea a2 = new TextArea("cvcxvcvvvxvcxvcvxcvxcvcxvxcvxcvxvx");
        a2.setEditable(false);
        theChat.add(a2);
        TextArea a3 = new TextArea("cvcxvcvvvxvcxvcvxcvxcvcxvxcvxcvxvx");
        a3.setEditable(false);
        theChat.add(a3);
        TextArea a4 = new TextArea("cvcxvcvvvxvcxvcvxcvxcvcxvxcvxcvxvx");
        a4.setEditable(false);
        theChat.add(a4);
        System.out.println(theChat.size());
        for (int i = 0; i < theChat.size(); i++) {
            ChatRoom.getChildren().add(theChat.elementAt(i));
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
