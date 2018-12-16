package richrail.domain;

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

    public ArrayList<RollingComponent> getRollingComponents() {
        return rollingComponents;
    }

    public void addRollingComponent(RollingComponent rollingComponent) {
        rollingComponents.add(rollingComponent);
    }

    public void removeRollingComponent(RollingComponent rollingComponent) {
        rollingComponents.remove(rollingComponent);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            Train train = (Train) object;
            if(this.name.equals(train.getName())) {
                return true;
            } else {
                return false;
            }
        }

        return false;

    }



}

