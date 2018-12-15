package richrail.gui;

import java.net.URL;

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

public class Controller implements Initializable {

    // Hier staan goede voorbeelden: https://gist.github.com/skrb/3052988
    // Je maakt dus een property aan zoals commandTextArea met @FXML notatie zoals hieronder
    // Daarna assign je de ID in sample.fxml bij de TextArea/Button of whatever met fx:id. Met buttons gebruik je onHandleAction in sample.fxml e

    @FXML
    private TextArea txtArea;

    @FXML
    GridPane gridpane;

    @FXML
    ChoiceBox choiceBox; // treinen

    /*
    Buttons
     */

    @FXML
    Button btn_addtrain;

    @FXML
    Button btn_addwagon;

    @FXML
    Button btn_addlocomotive;

    @FXML
    Button btn_deletewagon;

    @FXML
    Button btn_deletetrain;

    @FXML
    Button btn_deletelocomotive;

    @FXML
    Button btn_execute;

    private String selectedTrain;

    ObservableList<String> trains = FXCollections.observableArrayList("Nadir-trein", "Berkay-trein", "Sohaib-trein", "Moussa-trein", "Amin-trein");
    private int[] wagons = new int[trains.size()];
    private int[] locomotives = new int[trains.size()];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // amount of wagons per train
        wagons[0] = 1;
        wagons[1] = 2;
        wagons[2] = 3;
        wagons[3] = 5;
        wagons[4] = 1;

        // amount of locomotives per train
        locomotives[0] = 1;
        locomotives[1] = 2;
        locomotives[2] = 3;
        locomotives[3] = 5;
        locomotives[4] = 1;

        choiceBox.setItems(trains); // initialize available trains
    }

    private void createEverything() {
        gridpane.getChildren().clear(); // clear grid so that we can put everything back again based on the selected train

        //create train
        gridpane.add(new Button("Train"), 0, 0); // starts with 0, 0

        //create wagons
        int trainId = trains.indexOf(selectedTrain);
        if(trainId != -1) { // if selected train is null
            int w = 1;
            while (w < wagons[trainId]) {
                gridpane.add(new Button("Wagon " + w), w, 0); // starts on 1, 0 because train is on 0, 0
                w++;
            }
        }

        //create locomotives
//        int l = w;
//        while (l < locomotives) {
//            gridpane.add(new Button("Locomotive " + l), l, 0);
//            l++;
//        }
    }

    @FXML
    private void handleAction(ActionEvent event) {
        //txtArea.setText("ewa nadir");

        if(event.getSource() == choiceBox) {
            selectedTrain = choiceBox.getValue().toString();
            createEverything();
        }

        if(event.getSource() == btn_addtrain) {
        }
        else if(event.getSource() == btn_addwagon) {
        }
        else if(event.getSource() == btn_addlocomotive) {
        }
        else if(event.getSource() == btn_deletewagon) {
        }
        else if(event.getSource() == btn_deletetrain) {
        }
        else if(event.getSource() == btn_deletelocomotive) {
        }
        else if(event.getSource() == btn_execute) {
            System.out.println(choiceBox.getValue());
        }
        //System.out.println(trains.indexOf(selectedTrain));
    }

}
