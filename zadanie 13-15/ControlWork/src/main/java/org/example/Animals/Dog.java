package org.example.Animals;

import java.util.ArrayList;

public class Dog extends Pet{
    public Dog(String name) {
        super(name,AnimalEnum.DOG);
    }
    public Dog(String name, ArrayList<String> commands) {
        super(name, commands, AnimalEnum.DOG);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + "name - " + super.getName() +
                ", commands - " + super.getCommands();
    }
}
