package richrail.storage;

import javafx.collections.ObservableList;
import richrail.domain.RollingComponent;
import richrail.domain.Train;

import java.util.ArrayList;

public interface Storage {
    public Train createTrain(String name);
    public Train removeTrain(Train train);
    public Train addRollingComponent(RollingComponent rollingComponent);
    public ArrayList<Train> loadAllTrains();
    public Train findTrainByName(ObservableList<Train> arrayList, String trainName);

}
