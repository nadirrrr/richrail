package richrail.gui;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.ColumnConstraints;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import org.omg.CORBA.TRANSACTION_MODE;
import richrail.domain.Train;
import richrail.domain.Wagon;
import richrail.storage.FileStorage;
import richrail.storage.Storage;

public class Controller implements Initializable {

    // Hier staan goede voorbeelden: https://gist.github.com/skrb/3052988
    // Je maakt dus een property aan zoals commandTextArea met @FXML notatie zoals hieronder
    // Daarna assign je de ID in sample.fxml bij de TextArea/Button of whatever met fx:id. Met buttons gebruik je onHandleAction in sample.fxml e


    // These properties clearly need some refactor =) @berkay
    @FXML
    private TextArea txtArea;

    @FXML
    GridPane gridpane;

    @FXML
    ChoiceBox choiceBox; // treinen

    @FXML
    Button btn_addtrain;

    @FXML
    Button btn_addwagon;

    @FXML
    Button btn_deletewagon;

    @FXML
    Button btn_deletetrain;

    @FXML
    Button btn_execute;

    @FXML
    TextField txtf_trainname;

    private Image train = new Image("train.png");
    private Image wagon = new Image("wagon.png");

    private Train selectedTrain;


    private FileStorage fileStorage = new FileStorage();
    private ObservableList<Train> trains = FXCollections.observableArrayList(fileStorage.reloadTrainList());

    // @TODO: Fix NullPointerException bugs when selecting null objects, and finish file storage

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Assign the trainList after the fileStorage loads the list of all trains..
        refreshPage();

    }

    private void refreshPage() {

        choiceBox.setItems(trains); // initialize available trains

        gridpane.getChildren().clear(); // clear grid so that we can put everything back again based on the selected train

        //create train image
        gridpane.add(new ImageView(train), 0, 0); // starts with 0, 0

        //create wagons
        Train trainId = selectedTrain;
        if(trainId != null) {
            int w = 1;
            while (w < selectedTrain.getRollingComponents().size()) {
                gridpane.add(new ImageView(wagon), w, 0);
                w++;
            }


        }
    }

    private void addTrain(String trainName) {
        if(!trainName.equals("type train name")) { // nothing changed abort

            // @TODO: Change to boolean maybe.. :/
            if(fileStorage.findTrainByName(trainName) == null) {
                fileStorage.createTrain(trainName);
            }

        }

    }

    private void delTrain(Train train) {

        fileStorage.removeTrain(train);

    }

    private void addWagon(Train train) {
        System.out.println(train.getName());
        fileStorage.addRollingComponent(train, new Wagon(train.getName()));

    }

    private void delWagon(Train train) {
        if(train.getRollingComponents().size() > 0) {
            // @TODO: Doesn't seem like a perfect fix
            fileStorage.removeRollingComponent(train);
//            train.getRollingComponents().remove(train.getRollingComponents().size() - 1);
        }
    }

    @FXML
    private void handleAction(ActionEvent event) {

        if(event.getSource() == choiceBox) {
            try {
                selectedTrain = fileStorage.findTrainByName(choiceBox.getValue());
            } catch(Exception err) {
                // @TODO Looks like we ran in a NullPointerException because we are selecting a deleted train. Adjust this.
            }
        }

        if(event.getSource() == btn_addtrain) {
            addTrain(txtf_trainname.getText().toLowerCase()); // name of train
            trains = FXCollections.observableArrayList(fileStorage.reloadTrainList());
        }
        else if(event.getSource() == btn_addwagon) {
            addWagon(selectedTrain);
        }

        else if(event.getSource() == btn_deletewagon) {
            delWagon(selectedTrain);

        }

        else if(event.getSource() == btn_deletetrain) {
            delTrain(selectedTrain);
            trains = FXCollections.observableArrayList(fileStorage.reloadTrainList());
        }

        else if(event.getSource() == btn_execute) {
            System.out.println(choiceBox.getValue());
        }
        refreshPage();
    }

}
