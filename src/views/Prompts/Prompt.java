package views.Prompts;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by steve on 3/28/2017.
 */
public class Prompt {
    public  boolean display(String title,String meso,boolean close){
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);//to allow deal with current window first
    window.setTitle(title);
    window.setMinWidth(200);

    Button button = new Button("ok");
    button.setOnAction(e -> window.close());

    Label labe = new Label();
    labe.setText(meso);

    VBox box = new VBox();
    box.getChildren().addAll(labe,button);
    box.setAlignment(Pos.CENTER);
    box.setId("prompt");
    box.requestFocus();
    box.setOnKeyPressed( e ->{
        window.close();
    });
    Scene scene = new Scene(box);
    scene.getStylesheets().add(getClass().getResource("../style/main.css").toString());
    window.setScene(scene);
    window.initStyle(StageStyle.UNDECORATED);
    window.showAndWait();  //allows show and wait


        boolean ret = false;
    if(close){
        ConfirmBox confirmBox = new ConfirmBox();
       ret =  confirmBox.display("NEW GAME","PLAY NEW GAME");
    }
   return ret;
}
}
