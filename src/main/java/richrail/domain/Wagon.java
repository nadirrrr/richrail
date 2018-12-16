package richrail.domain;

import java.awt.*;
import java.util.ArrayList;

public class Wagon implements RollingComponent {

    private Train train;

    public Wagon(Train train) {
        this.train = train;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            Train train = (Train) object;
            if(this.train.getName().equals(train.getName())) {
                return true;
            } else {
                return false;
            }
        }

        return false;

    }

}
