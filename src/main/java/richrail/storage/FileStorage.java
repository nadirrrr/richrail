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

    private Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(RollingComponent.class, new InterfaceAdapter<RollingComponent>()).create();
    private ArrayList<Train> trainList = new ArrayList<>();

    public FileStorage() {

        this.loadAllTrains();

    }

    public ArrayList<Train> reloadTrainList() {
        return this.loadAllTrains();
    }

    private void writeJsonToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("controller.json"));
            writer.write(gson.toJson(trainList) + "\n");
            writer.close();

        } catch (IOException err) {
            System.out.println("Error.");
        }
    }

    @Override
    public Train findTrainByName(Object object) {
        for (Train train : trainList) {
             if (train.getName().equals(object.toString())) {
                    return train;
                }
            }
        return null;
    }




    @Override
    public Train createTrain(String name) {

        Train train = new Train(name);
        trainList.add(train);

        writeJsonToFile();

        return null;
    }

    @Override
    public Train removeTrain(Train train) {
        trainList.remove(findTrainByName(train)); // verwijder uit list
        System.out.println(trainList);
        writeJsonToFile(); // schrijf naar bestand

        return null;
    }

    @Override
    public Train addRollingComponent(Train train, RollingComponent rollingComponent) {


        train.addRollingComponent(rollingComponent);
        System.out.println(trainList.get(1).getRollingComponents());
        writeJsonToFile();



        return train;
    }

    @Override
    public Train removeRollingComponent(Train train) {
        train.getRollingComponents().remove(train.getRollingComponents().size() - 1);
        writeJsonToFile();

        return train;

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
            // Seems like the json file does not exist. Let's create it. @TODO: Change this
            this.writeJsonToFile();
            System.out.println("IOException: " + err.getMessage());
        }

        return trainList;
    }

}
