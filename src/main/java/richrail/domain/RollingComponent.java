package richrail.domain;

import java.awt.*;
import java.util.ArrayList;

public interface RollingComponent {
    // @TODO The current train & offset is temp - add relation ASAP
    public ArrayList<RollingComponent> getAllComponents();
    public Graphics drawComponent(Graphics g, int currentTrain, int offset);
    public Graphics drawComponent(Graphics g, int currentNumberOfWagons, int TRAINLENGTH, int currentTrain, int OFFSET);
}
