package richrail.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // Hier staan goede voorbeelden: https://gist.github.com/skrb/3052988
    // Je maakt dus een property aan zoals commandTextArea met @FXML notatie zoals hieronder
    // Daarna assign je de ID in sample.fxml bij de TextArea/Button of whatever met fx:id. Met buttons gebruik je onHandleAction in sample.fxml e
    @FXML
    private TextArea commandTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // @TODO
    }

    @FXML
    private void handleAction(ActionEvent event) {
        commandTextArea.setText("ewa berkay");
    }

}
