package org.example.Animals;

import java.util.ArrayList;

public abstract class Animal {
    private String name;
    private ArrayList<String> commands = new ArrayList<String>();
    private String type;

    public Animal(String name, AnimalEnum type) {
        this.name = name;
        this.type = String.valueOf(type);
    }

    public Animal(String name, ArrayList<String> commands, AnimalEnum type) {
        this.name = name;
        this.commands = commands;
        this.type = String.valueOf(type);;
    }
    public String toSaveFormat(){
        StringBuilder sb = new StringBuilder();
        sb.append(getName())
                .append(";")
                .append(getCommands())
                .append(";")
                .append(getType())
                .append("\n");
        return sb.toString();
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
    public ArrayList<String> getCommandsList() {
        return commands;
    }
    public void setCommands(String  command) {
        String[] commandsNew = command.split(",");
        for (String c:commandsNew){
            this.commands.add(command);
        }
    }

    public String getType() {
        return type;
    }

//    @Override
//    public String toString() {
//        return "Animal: " + "name - " + name + ", commands - {" + getCommands() + "}";
//    }
}
