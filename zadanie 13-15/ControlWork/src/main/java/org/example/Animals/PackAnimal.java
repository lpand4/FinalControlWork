package org.example.Animals;

import java.util.ArrayList;

public abstract class PackAnimal extends Animal{
        public PackAnimal(String name, AnimalEnum type) {
        super(name, type);
    }
        public PackAnimal(String name, ArrayList<String> commands, AnimalEnum type) {
            super(name, commands, type);
        }
}
