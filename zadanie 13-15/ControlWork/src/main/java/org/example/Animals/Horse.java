package org.example.Animals;

public class Horse extends PackAnimal{
    public Horse(String name) {
        super(name, AnimalEnum.HORSE);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + "name - " + super.getName() +
                ", commands - " + super.getCommands();
    }
}
