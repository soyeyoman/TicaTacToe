package controllers;

import Models.Game;
import Models.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import views.Prompts.AfterWin;
import views.Prompts.ConfirmBox;
import java.io.IOException;
import java.util.Random;

/**
 * Created by steve on 9/25/2017.
 */
public class GameController {
@FXML GridPane  gameview;
@FXML Label gamelabel;

Game game ;
Player playerOne;
Player playerTwo;
Player man;
Boolean started = false;
MediaPlayer mp;
    public void setPoint(MouseEvent e) throws IOException {
        gameview.getChildren().forEach(t -> {
            if (t.equals(e.getSource())) {

                TextField w = (TextField) t;
                if (w.getText().equals("") && started) {
                    boolean win = game.setPoint(t.getId(), man.getMark());
                    w.setText(String.format("%c", man.getMark()));
                    w.getStyleClass().add(man.getMark()+"text");
                    checkwin(win);
                }
            }
        });

    }

    private void checkwin(Boolean win) {
        if (!win) {
            if (playerOne.isActive()) {
                playerOne.setActive(false);
                playerTwo.setActive(true);
                man = playerTwo;
                gamelabel.setText(String.format(man.getName() + " play for : " + man.getMark()));
            } else {
                playerTwo.setActive(false);
                playerOne.setActive(true);
                man = playerOne;
                gamelabel.setText(String.format(man.getName() + " play for : " + man.getMark()));
            }
        } else {
            AfterWin winprompt = new AfterWin();
            String next = winprompt.display();
            Stage stage = (Stage)gameview.getScene().getWindow();
            switch (next){
                case "refresh":
                    init(playerOne.getName(),playerTwo.getName());
                    started = false;
                    mp.stop();
                    break;
                case "exit":
                    ConfirmBox confirmBox = new ConfirmBox();
                    boolean exit = confirmBox.display("Exit","Exit Game !!");
                    if(exit){
                        stage.close();
                        break;
                    }
                case "new":
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("../views/fxmlViews/welcome.fxml"));
                        stage.setScene(new Scene(root));
                        mp.stop();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void init(String play1,String play2){
        playerOne = new Player(play1,'x',false);
        playerTwo = new Player(play2,'o',false);

        Random gen = new Random();
        int n = gen.nextInt(2);

        if(n == 1){
            man = playerOne;
            playerOne.setActive(true);
        }else{
            man = playerTwo;
            playerTwo.setActive(true);
        }
        game = new Game();

        mp = new MediaPlayer(new Media(getClass().getResource("../media/game.mp3").toString()));
        mp.setCycleCount(-1);
        mp.play();

        gameview.getChildren().forEach(t->{
            t.getStyleClass().forEach(st ->{
                if(st.equals("text")){
                    ((TextField) t).setText("");
                }
            });
        });

        gamelabel.setText("Press Enter to Start");
    }

    public void startGame(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER) && !started){
            started = true;
            gamelabel.setText(man.getName()+" play for "+man.getMark());
        }

    }

    public void initialize(){
        gameview.getChildren().forEach(t->{
            t.getStyleClass().forEach(st ->{
                if(st.equals("text")){
                    t.setCursor(Cursor.HAND);
                    TextField w  = (TextField) t;
                    w.setAlignment(Pos.CENTER);
                }
            });
        });
    }

    public void exit() {
        Stage stage = (Stage)gameview.getScene().getWindow();
        ConfirmBox confirmBox = new ConfirmBox();
        boolean exit = confirmBox.display("Exit","Exit Game !!");
        if(exit){
            stage.close();
        }
    }
}

