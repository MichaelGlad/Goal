package net.glm.goal;

/**
 * Created by ORAN on 15/03/2018.
 */

public class Level {

    String name;



    public Level(String leveks) {
        this.name = leveks;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Level{" +
                "name='" + name + '\'' +
                '}';
    }
}
