package org.example.Animals;

import java.util.ArrayList;

public abstract class Pet extends Animal{

    public Pet(String name, AnimalEnum type) {
        super(name, type);
    }

    public Pet(String name, ArrayList<String> commands, AnimalEnum type) {
        super(name, commands, type);
    }
}
