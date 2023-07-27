package org.example.Animals;

import java.util.ArrayList;

public class Horse extends PackAnimal{
    public Horse(String name) {
        super(name, AnimalEnum.HORSE);
    }
    public Horse(String name, ArrayList<String> commands) {
        super(name, commands, AnimalEnum.HORSE);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + "name - " + super.getName() +
                ", commands - " + super.getCommands();
    }
}
