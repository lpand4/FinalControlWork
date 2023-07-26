package org.example.Animals;

public class Dog extends Pet{
    public Dog(String name) {
        super(name,AnimalEnum.DOG);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + "name - " + super.getName() +
                ", commands - " + super.getCommands();
    }
}
