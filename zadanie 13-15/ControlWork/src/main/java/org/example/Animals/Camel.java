package org.example.Animals;

import java.util.ArrayList;

public class Camel extends PackAnimal{
    public Camel(String name) {
        super(name, AnimalEnum.CAMEL);
    }
    public Camel(String name, ArrayList<String> commands) {
        super(name, commands, AnimalEnum.CAMEL);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + "name - " + super.getName() +
                ", commands - " + super.getCommands();
    }
}
