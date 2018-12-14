import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class GUI extends Application {
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Users/berkaysimsek/IdeaProjects/richrail/GUI.fxml"));

        Scene scene = new Scene(root, 300, 275);

        stage.setTitle("Train system");
        stage.setScene(scene);
        //stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
