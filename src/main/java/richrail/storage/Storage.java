package richrail.storage;

import richrail.domain.Train;

import java.util.ArrayList;

public interface Storage {
    public Train createTrain(String name);
    public Train removeTrain(Train train);
    public Train updateTrain(Train train);
    public ArrayList<Train> listAllTrains();
}
