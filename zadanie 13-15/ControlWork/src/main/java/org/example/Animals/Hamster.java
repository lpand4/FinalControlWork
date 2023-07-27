package org.example.Animals;

import java.util.ArrayList;

public class Hamster extends Pet{
    public Hamster(String name) {
        super(name,AnimalEnum.HAMSTER);
    }

    public Hamster(String name, ArrayList<String> commands) {
        super(name, commands, AnimalEnum.HAMSTER);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + "name - " + super.getName() +
                ", commands - " + super.getCommands();
    }

//    public static void main(String[] args) {
//        Hamster h = new Hamster("Gosha");
//        System.out.println(h);
//    }
}

