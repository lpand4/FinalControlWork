package org.example.Animals;

public class Hamster extends Pet{
    public Hamster(String name) {
        super(name,AnimalEnum.HAMSTER);
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

