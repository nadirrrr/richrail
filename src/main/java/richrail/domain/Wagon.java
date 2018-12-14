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

    // @TODO: Temporarily. We're gonna adjust the logic behind this
    @Override
    public Graphics drawComponent(Graphics g, int currentTrain, int offset) {
        return null;
    }

    // @TODO: Temporarily. We're gonna adjust the logic behind this
    @Override
    public Graphics drawComponent(Graphics g, int currentNumberOfWagons, int TRAINLENGTH, int currentTrain, int OFFSET) {

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(30+currentNumberOfWagons*TRAINLENGTH,80+currentTrain*OFFSET,80,40);
        g.setColor(Color.BLACK);
        g.fillRoundRect(35+currentNumberOfWagons*TRAINLENGTH, 120+currentTrain*OFFSET, 20, 20, 20, 20);
        g.fillRoundRect(80+currentNumberOfWagons*TRAINLENGTH, 120+currentTrain*OFFSET, 20, 20, 20, 20);
        g.drawString(train.getName(),40+currentNumberOfWagons*TRAINLENGTH,105+currentTrain*OFFSET);

        return g;

    }
}
