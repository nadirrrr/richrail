package richrail.domain;

import java.awt.*;
import java.util.ArrayList;

public class Locomotive implements RollingComponent {

    private Train train;


    public Locomotive(Train train) {

        this.train = train;
    }

}
