package richrail.domain;

import java.awt.*;
import java.util.ArrayList;

public class Wagon implements RollingComponent {

    private Train train;

    public Wagon() { }
    public Wagon(Train train) {
        this.train = train;
    }

    @Override
    public ArrayList<RollingComponent> getAllComponents() {
        return null;
    }

}
