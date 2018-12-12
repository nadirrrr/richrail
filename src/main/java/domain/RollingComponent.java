package domain;

import java.awt.*;
import java.util.ArrayList;

interface RollingComponent {
    // @TODO The current train & offset is temp - add relation ASAP
    public ArrayList<RollingComponent> getAllComponents();
    public Graphics drawComponent(Graphics g, int currentTrain, int offset);
}
