package domain;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Train {

    private String name;
    private ArrayList<RollingComponent> rollingComponents = new ArrayList<>();

    public Train(String name) {

        this.name = name;

    }

    public String getName() {

        return this.name;

    }

    public void addRollingComponent(RollingComponent rollingComponent) {
        rollingComponents.add(rollingComponent);
    }

}
