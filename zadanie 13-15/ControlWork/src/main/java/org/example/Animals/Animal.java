package org.example.Animals;

import java.util.ArrayList;

public abstract class Animal {
    private String name;
    private ArrayList<String> commands = new ArrayList<String>();

    private AnimalEnum type;

    public Animal(String name, AnimalEnum type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommands() {
        return commands.toString();
    }

    public void setCommands(String  command) {
        this.commands.add(command);
    }

//    @Override
//    public String toString() {
//        return "Animal: " + "name - " + name + ", commands - {" + getCommands() + "}";
//    }
}
