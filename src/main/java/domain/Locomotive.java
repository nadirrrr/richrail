package domain;

import java.awt.*;
import java.util.ArrayList;

public class Locomotive implements RollingComponent {

    private Train train;


    public Locomotive(Train train) {

        this.train = train;
    }

    @Override
    public ArrayList<RollingComponent> getAllComponents() {
        return null;
    }


    @Override
    public Graphics drawComponent(Graphics g, int currentTrain, int offset) {

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(30,80+currentTrain*offset,80,40);
        g.fillRect(80,60+currentTrain*offset,30,30);
        g.drawRoundRect(85, 40+currentTrain*offset, 20, 20, 20, 20);
        g.drawRoundRect(85, currentTrain*offset, 40, 40, 40, 40);
        g.setColor(Color.BLACK);
        g.fillRoundRect(35, 120+currentTrain*offset, 20, 20, 20, 20);
        g.fillRoundRect(80, 120+currentTrain*offset, 20, 20, 20, 20);
        g.drawString(train.getName(),40,105+currentTrain*offset);

        return g;
    }

    // @TODO: Temporarily. We're gonna adjust the logic behind this
    @Override
    public Graphics drawComponent(Graphics g, int currentNumberOfWagons, int TRAINLENGTH, int currentTrain, int OFFSET) {
        return null;
    }

}
