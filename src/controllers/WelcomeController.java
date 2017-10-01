package controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import views.Prompts.ConfirmBox;
import views.Prompts.Prompt;

import java.io.IOException;


/**
 * Created by steve on 9/25/2017.
 */
public class WelcomeController {

    public static boolean isSplashed = false;
    @FXML StackPane rootWelcome;
    @FXML Button setPlayerbtn;
    @FXML JFXTextField play1;
    @FXML JFXTextField play2;
    MediaPlayer mp ;
    public void initialize(){
        if(!WelcomeController.isSplashed){
            loadSplashScreen();
        }else{
           mp = new MediaPlayer(new Media(getClass().getResource("../media/intro.mp3").toString()));
           mp.setCycleCount(MediaPlayer.INDEFINITE);
           mp.play();
        }
        play1.setCursor(Cursor.HAND);
        play2.setCursor(Cursor.HAND);
        setPlayerbtn.setCursor(Cursor.HAND);
        rootWelcome.setCursor(Cursor.HAND);
    }

    private void loadSplashScreen() {
        try{
            WelcomeController.isSplashed = true;
            StackPane pane = FXMLLoader.load(getClass().getResource("../views/fxmlViews/splash.fxml"));
            rootWelcome.getChildren().setAll(pane);
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(4),pane);
            fadeIn.setFromValue(0.3);
            fadeIn.setToValue(1);

            FadeTransition fadeout = new FadeTransition(Duration.seconds(4),pane);
            fadeout.setFromValue(1);
            fadeout.setToValue(0.3);

            fadeout.setOnFinished(e->{
                    try {
                        StackPane pane1 = FXMLLoader.load(getClass().getResource("../views/fxmlViews/welcome.fxml"));
                        rootWelcome.getChildren().setAll(pane1);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
            });
            fadeIn.setOnFinished(e->{
                fadeout.play();
            });

            fadeIn.play();
        }catch (Exception e){

        }
    }

    public void game() throws IOException {
        if(play1.getText().equals("") || play2.getText().equals("")){
            Prompt prompt = new Prompt();
            prompt.display("Warning","Enter all players",false);
        }else{
            Stage stage = (Stage)setPlayerbtn.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/fxmlViews/game.fxml"));
            Parent root = loader.load();
            GameController con = loader.getController();
            con.init(play1.getText(), play2.getText());
            stage.setScene(new Scene(root,600,400));
            stage.show();
            mp.stop();
        }

    }
    public void exit() {
        Stage stage = (Stage)play2.getScene().getWindow();
        ConfirmBox confirmBox = new ConfirmBox();
        boolean exit = confirmBox.display("Exit","Exit Game !!");
        if(exit){
            stage.close();
        }
    }
}
