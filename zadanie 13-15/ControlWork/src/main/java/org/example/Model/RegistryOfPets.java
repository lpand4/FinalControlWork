package org.example.Model;

import org.example.Animals.*;
import org.example.View.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RegistryOfPets implements IRegestryOfPets{
    private List<Animal> animals;
    View v = new View();


    public RegistryOfPets() {
        this.animals = new ArrayList<>();
    }
    public RegistryOfPets(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public void addNewAnimal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите тип животного, которое хотите добавить: ");
        String typeStr = sc.nextLine();
        Animal animal;
        switch (typeStr.toLowerCase()){
            case("hamster"), ("donkey"), ("dog"), ("cat"), ("camel"), ("horse"):
                this.animals.add(createAnimal(typeStr.toLowerCase()));
                break;
            default:
                System.out.println("Такого животного не может быть в реестре!");
                break;
        }
    }

    private Animal createAnimal(String type){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя животного: ");
        String name = sc.nextLine();
        String[] command;
        System.out.println("Введите комманды, которые выполняет животное через запятую: ");
        command = sc.nextLine().split(",");
        ArrayList<String> commands = new ArrayList<>();
        Collections.addAll(commands, command);
        Animal animal;
        switch (type){
            case("hamster"):
                animal = new Hamster(name, commands);
                return animal;
            case("dog"):
                animal = new Dog(name, commands);
                return animal;
            case("cat"):
                animal = new Cat(name, commands);
                return animal;
            case("camel"):
                animal = new Camel(name, commands);
                return animal;
            case("horse"):
                animal = new Horse(name, commands);
                return animal;
            case("donkey"):
                animal = new Donkey(name, commands);
                return animal;
            default:
                return null;
        }
    }

    @Override
    public Animal seeCommands() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        Animal result = null;
        do{
            v.showRegistry(animals);
            System.out.println("Введите номер животного, команды которого хотите посмотреть: ");
            String numberOfAnimal = sc.nextLine();
            if(numberOfAnimal.chars().allMatch(Character::isDigit)
                    && !numberOfAnimal.isEmpty()
                    && Integer.parseInt(numberOfAnimal) <= animals.size()){
                result = animals.get(Integer.parseInt(numberOfAnimal) - 1);
                flag = false;
            }
        }while (flag);
        return result;
    }

    @Override
    public void teachNewCommand() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        Animal result = null;
        do{
            v.showRegistry(animals);
            System.out.println("Введите номер животного, команды которого хотите обучить новым командам: ");
            String numberOfAnimal = sc.nextLine();
            String learnedCommands;
            if(numberOfAnimal.chars().allMatch(Character::isDigit)
                    && !numberOfAnimal.isEmpty()
                    && Integer.parseInt(numberOfAnimal) <= animals.size()){

                result = animals.get(Integer.parseInt(numberOfAnimal) - 1);
                v.showCommands(result);
                System.out.println("Допишите через запятую комманды, которым научился " + result.getName() + ":");
                learnedCommands = sc.nextLine();
                result.setCommands(learnedCommands);
                flag = false;
            }
        }while (flag);
    }

//    public static void main(String[] args) {
//        RegistryOfPets rp = new RegistryOfPets();
//        rp.addNewAnimal();
//        System.out.println(rp.getAnimals());
//        rp.addNewAnimal();
//        System.out.println(rp.getAnimals());
//
//    }
}
