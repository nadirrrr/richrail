package domain;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Train {

    private String name;
    private ArrayList<RollingComponent> rollingComponents;


    public Train(String name) {
        this.name = name;
    }
    public Train(String name, ArrayList<RollingComponent> rollingComponents) {
        this.name = name;
        this.rollingComponents = rollingComponents;
    }

    public String getName() {
        return name;
    }

}
