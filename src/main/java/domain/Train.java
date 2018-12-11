package domain;

import java.util.ArrayList;

public class Train {

    private String name;
    private ArrayList<RollingComponent> rollingComponents;

    public Train(String name, ArrayList<RollingComponent> rollingComponents) {
        this.name = name;
        this.rollingComponents = rollingComponents;
    }
}
