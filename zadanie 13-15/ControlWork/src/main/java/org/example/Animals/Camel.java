package org.example.Animals;

public class Camel extends PackAnimal{
    public Camel(String name) {
        super(name, AnimalEnum.CAMEL);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + "name - " + super.getName() +
                ", commands - " + super.getCommands();
    }
}
