package org.example.Animals;

import java.util.ArrayList;

public class Cat extends Pet{
    public Cat(String name) {
        super(name, AnimalEnum.CAT);
    }
    public Cat(String name, ArrayList<String> commands) {
        super(name, commands, AnimalEnum.CAT);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + "name - " + super.getName() +
                ", commands - " + super.getCommands();
    }
}
