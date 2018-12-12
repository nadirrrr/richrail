package domain;

import java.awt.*;
import java.util.ArrayList;

public class Wagon implements RollingComponent {

    private Train train;

    public Wagon(Train train) {
        this.train = train;
    }

    @Override
    public ArrayList<RollingComponent> getAllComponents() {
        return null;
    }

    @Override
    public Graphics drawComponent(Graphics g, int currentTrain, int offset) {
        return null;
    }
}
