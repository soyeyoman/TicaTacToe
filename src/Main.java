import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import views.Prompts.ConfirmBox;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/fxmlViews/welcome.fxml"));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setOnCloseRequest(e ->{
            e.consume();
            closeProgram(primaryStage);
        });
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
    public void closeProgram(Stage window){
        ConfirmBox confirmBox = new ConfirmBox();
        boolean ans = confirmBox.display("CLOSE !!","Do you want to exit");
        if(ans) window.close();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
