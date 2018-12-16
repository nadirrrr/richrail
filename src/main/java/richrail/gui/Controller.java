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
import richrail.domain.Locomotive;
import richrail.domain.RollingComponent;
import richrail.domain.Train;
import richrail.domain.Wagon;
import richrail.parser.TrainCliService;
import richrail.storage.FileStorage;
import richrail.storage.Storage;

public class Controller implements Initializable {

    @FXML
    TextArea txtArea;

    @FXML
    GridPane gridPane;

    @FXML
    ChoiceBox choiceBox;

    @FXML
    Button btnAddTrain;

    @FXML
    Button btnAddWagon;

    @FXML
    Button btnAddLocomotive;

    @FXML
    Button btnDeleteComponent;

    @FXML
    Button btnDeleteTrain;

    @FXML
    Button btnExecute;

    @FXML
    TextField cliCommand;

    @FXML
    TextField textFieldTrainName;

    private Image train = new Image("train.png");
    private Image wagon = new Image("wagon.png");

    private Train selectedTrain;

    private FileStorage fileStorage = new FileStorage();
    private ObservableList<Train> trains = FXCollections.observableArrayList(fileStorage.reloadTrainList());
    private TrainCliService trainCliService = new TrainCliService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        refreshPage();

    }

    private void refreshPage() {

        choiceBox.setItems(trains);

        gridPane.getChildren().clear();
        gridPane.add(new ImageView(train), 0, 0); // starts with 0, 0

        Train trainId = selectedTrain;
        if(trainId != null) {
            int w = 1;
            while (w < selectedTrain.getRollingComponents().size()) {

                for(RollingComponent rollingComponent : selectedTrain.getRollingComponents()) {
                    if(rollingComponent instanceof Wagon) {

                        gridPane.add(new ImageView(wagon), w, 0);
                        w++;

                    }
                    else if (rollingComponent instanceof Locomotive) {
                        gridPane.add(new ImageView(train), w, 0);
                        w++;
                    }
                }
            }


        }
    }

    private void addTrain(String trainName) {

        if(!trainName.equals("type train name")) { // nothing changed abort

                fileStorage.createTrain(trainName);

        }

    }

    @FXML
    private void handleAction(ActionEvent event) {

        if(event.getSource() == choiceBox) {
            try {
                selectedTrain = fileStorage.findTrainByName(choiceBox.getValue());
            } catch(Exception err) {
                // @TODO Looks like we ran in a NullPointerException because we are selecting a deleted train. Probably there is a better solution for this?.
            }
        }

        if(event.getSource() == btnAddTrain) {
            addTrain(textFieldTrainName.getText().toLowerCase()); // name of train
            trains = FXCollections.observableArrayList(fileStorage.reloadTrainList());
        }
        else if(event.getSource() == btnAddWagon) {
            fileStorage.addRollingComponent(selectedTrain, new Wagon("waggonnetje"));
        }

        else if(event.getSource() == btnAddLocomotive) {
            fileStorage.addRollingComponent(selectedTrain, new Locomotive("locomotiefje"));
        }
        else if(event.getSource() == btnDeleteComponent) {
            fileStorage.removeRollingComponent(selectedTrain);

        }

        else if(event.getSource() == btnDeleteTrain) {

            fileStorage.removeTrain(selectedTrain);

            trains = FXCollections.observableArrayList(fileStorage.reloadTrainList());

        }

        else if(event.getSource() == btnExecute) {
            trainCliService.sendCommand(cliCommand.getText());
            txtArea.setText(cliCommand.getText() + "\n");
            trains = FXCollections.observableArrayList(fileStorage.loadAllTrains());
            System.out.println(cliCommand.getText());
        }
        refreshPage();
    }

}