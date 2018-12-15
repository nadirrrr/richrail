package richrail.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import richrail.domain.Train;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileStorage implements Storage {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void initialize() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/nadir/asd.json"));
            writer.write("Hello.");
            writer.close();

        } catch (IOException err) {
            System.out.println("Error.");
        }
    }

    @Override
    public Train createTrain(String name) {


        return null;
    }

    @Override
    public Train removeTrain(Train train) {
        return null;
    }

    @Override
    public Train updateTrain(Train train) {
        return null;
    }

    @Override
    public ArrayList<Train> listAllTrains() {
        return null;
    }
}
