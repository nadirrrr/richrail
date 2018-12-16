package richrail.domain;

import java.awt.*;
import java.util.ArrayList;

public class Wagon implements RollingComponent {

    private String name;

    public Wagon(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
