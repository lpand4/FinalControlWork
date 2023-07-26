package org.example.Animals;

public class Cat extends Pet{
    public Cat(String name) {
        super(name, AnimalEnum.CAT);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + "name - " + super.getName() +
                ", commands - " + super.getCommands();
    }
}
