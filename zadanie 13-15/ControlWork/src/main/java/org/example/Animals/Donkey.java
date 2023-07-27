package org.example.Animals;

import java.util.ArrayList;

public class Donkey extends PackAnimal{
    public Donkey(String name) {
        super(name, AnimalEnum.DONKEY);
    }
    public Donkey(String name, ArrayList<String> commands) {
        super(name, commands, AnimalEnum.DONKEY);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + "name - " + super.getName() +
                ", commands - " + super.getCommands();
    }
}
