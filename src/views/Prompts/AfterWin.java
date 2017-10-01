package views.Prompts;

import com.jfoenix.controls.JFXButton;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by steve on 10/1/2017.
 */
public class AfterWin {
    //stores result to send back
     String result = "";
    public  String display(){
         Stage stage = new Stage();
        //setup buttons
         JFXButton refresh = new JFXButton("Refresh");
         JFXButton newGame = new JFXButton("New Game");
         JFXButton exit = new JFXButton("Exit");

         //setup eventlisteners
         refresh.setOnAction(e->{
             result = "refresh";
             stage.close();
         });
         newGame.setOnAction(e->{
             result = "new";
             stage.close();
         });
         exit.setOnAction(e->{
             result = "exit";
             stage.close();
         });

         //setup box arrangement and style
         VBox box = new VBox();
         box.getChildren().addAll(refresh,newGame,exit);
         box.prefHeight(350);
         box.prefWidth(250);
         box.getChildren().forEach( child ->{
             JFXButton btn = (JFXButton)child;
             btn.setPrefSize(250,117);
             btn.getStyleClass().add("Fxbtn");
             btn.getStylesheets().add(getClass().getResource("../style/main.css").toString());
         });

         //setup stage and scene
         stage.setScene(new Scene(box,250,350));
         stage.initStyle(StageStyle.UNDECORATED);
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.showAndWait();

        return result;
    }

}
