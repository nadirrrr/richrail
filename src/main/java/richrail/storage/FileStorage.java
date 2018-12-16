package richrail.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.collections.ObservableList;
import richrail.domain.RollingComponent;
import richrail.domain.Train;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileStorage implements Storage {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public ArrayList<Train> trainList = new ArrayList<>();

    public FileStorage() {

        this.loadAllTrains();

    }

    private void writeJsonToFile(String jsonString) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("controller.json"));
            writer.write(jsonString + "\n");
            writer.close();

        } catch (IOException err) {
            System.out.println("Error.");
        }
    }

    @Override
    public Train findTrainByName(ObservableList<Train> arrayList, String trainName) {
        for(Train train : arrayList) {
            if(train.getName().equals(trainName)) {
                return train;
            }
        }
        return null;
    }




    @Override
    public Train createTrain(String name) {

        Train train = new Train(name);
        trainList.add(train);

        writeJsonToFile(gson.toJson(trainList));

        return null;
    }

    @Override
    public Train removeTrain(Train train) {
        return null;
    }

    @Override
    public Train addRollingComponent(RollingComponent rollingComponent) {
        return null;
    }

    @Override
    public ArrayList<Train> loadAllTrains() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("controller.json"));
            String jsonData = "";
            String line = reader.readLine();

            while (line != null) {
                jsonData += line;
                line = reader.readLine();
            }

            TypeToken<ArrayList<Train>> token = new TypeToken<ArrayList<Train>>() {};
            trainList = gson.fromJson(jsonData, token.getType());

            reader.close();

        } catch (IOException err) {
            System.out.println("IOException: " + err.getMessage());
        }

        return trainList;
    }

}
