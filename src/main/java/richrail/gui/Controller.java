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

    @FXML
    TextField txtf_trainname;

    private Image train = new Image("train.png");
    private Image wagon = new Image("wagon.png");

    private String selectedTrain;

    ObservableList<String> trains = FXCollections.observableArrayList("nadir-trein", "berkay-trein", "sohaib-trein", "moussa-trein", "amin-trein");
    HashMap<Integer, Integer> wagons = new HashMap<>();
    HashMap<Integer, Integer> locomotives = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refreshPage();

        /*
            Dummy info
         */

        // amount of wagons per train
        for(int i = 0; i < trains.size(); i++) {
            int random = (int)(Math.random() * 5 + 1); // max 5, min 1
            int random2 = (int)(Math.random() * 5 + 1); // max 5, min 1
            wagons.put(i, random);
            locomotives.put(i, random2);
        }
    }

    private void refreshPage() {

        choiceBox.setItems(trains); // initialize available trains

        gridpane.getChildren().clear(); // clear grid so that we can put everything back again based on the selected train

        //create train
        //gridpane.add(new Button("Train"), 0, 0); // starts with 0, 0
        gridpane.add(new ImageView(train), 0, 0); // starts with 0, 0

        //create wagons
        int trainId = trains.indexOf(selectedTrain);
        if(trainId != -1) { // if selected train is null
            int w = 1;
            while (w < wagons.get(trainId)) {
                //gridpane.add(new Button("Wagon " + w), w, 0); // starts on 1, 0 because train is on 0, 0
                gridpane.add(new ImageView(wagon), w, 0); // starts with 0, 0
                w++;
            }

            //create locomotives
//        int l = w;
//        while (l < locomotives) {
//            gridpane.add(new Button("Locomotive " + l), l, 0);
//            l++;
//        }
        }
//        System.out.println("trains: " + trains + " size: " + trains.size());
//        System.out.println("wagons: " + wagons + " size: " + wagons.size());
//        System.out.println("locomotives: " + locomotives + " size: " + locomotives.size());
    }

    private void addTrain(String trainName) {
        int size = trains.size();
        if(!trainName.equals("type train name")) { // nothing changed abort
            if(!trains.contains(trainName)) { // record already exists abort
                trains.add(trainName); // if not add to trains success
            }
            //System.out.println(trains.contains(trainName));
        }
        wagons.put(size,0);
        locomotives.put(size,0);
    }

    private void delTrain(String trainName) {
        int index = trains.indexOf(trainName);
        trains.remove(index);
    }

    private void addWagon(int key) {
        wagons.put(key, wagons.get(key)+1);
    }

    private void delWagon(int key) {
        wagons.put(key, wagons.get(key)-1);
    }

    @FXML
    private void handleAction(ActionEvent event) {
        //txtArea.setText("ewa nadir");

        if(event.getSource() == choiceBox) {
            selectedTrain = choiceBox.getValue().toString();
        }

        if(event.getSource() == btn_addtrain) {
            addTrain(txtf_trainname.getText().toLowerCase()); // name of train
        }
        else if(event.getSource() == btn_addwagon) {
            int key = trains.indexOf(selectedTrain);
            addWagon(key);
        }
        else if(event.getSource() == btn_addlocomotive) {
        }
        else if(event.getSource() == btn_deletewagon) {
            int key = trains.indexOf(selectedTrain);
            delWagon(key);
        }
        else if(event.getSource() == btn_deletetrain) {
            selectedTrain = choiceBox.getValue().toString();
            delTrain(selectedTrain);
        }
        else if(event.getSource() == btn_deletelocomotive) {
        }
        else if(event.getSource() == btn_execute) {
            System.out.println(choiceBox.getValue());
        }
        refreshPage();
        //System.out.println(trains.indexOf(selectedTrain));
    }

}
