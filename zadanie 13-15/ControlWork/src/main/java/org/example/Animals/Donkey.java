package org.example.Animals;

public class Donkey extends PackAnimal{
    public Donkey(String name) {
        super(name, AnimalEnum.DONKEY);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + "name - " + super.getName() +
                ", commands - " + super.getCommands();
    }
}
