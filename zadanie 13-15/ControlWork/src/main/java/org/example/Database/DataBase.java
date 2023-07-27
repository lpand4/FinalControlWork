package org.example.Database;

import org.example.Animals.*;
import org.example.Model.RegistryOfPets;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase implements IDatabase {
    private RegistryOfPets registry;
    final private String registryFilename = "RegistryOfPets.txt";



    public DataBase(RegistryOfPets animals){
        this.registry = animals;

    }

    @Override
    public void saveData(RegistryOfPets animals) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(registryFilename))) {
            for (Animal animal : animals.getAnimals()) {
                bufferedWriter.write(animal.toSaveFormat());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        @Override
    public RegistryOfPets readDataFromFile() {
        this.registry = readAnimalsFromFile();
        return registry;
    }

    private RegistryOfPets readAnimalsFromFile() {

        RegistryOfPets registry;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(registryFilename))) {
            List<Animal> animals = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine())!=null){
                animals.add(parseAnimalFromFile(line));
            }
            registry = new RegistryOfPets(animals);
        } catch (IOException e) {
            return new RegistryOfPets();
        }
        return registry;
    }

    private Animal parseAnimalFromFile(String line){
        String[] parts = line.split(";");
        String name = parts[0];
        String commandsText = parts[1];
        ArrayList<String> commands = parseCommands(commandsText);
        String type = parts[2];
        Animal animal;
        switch (type.toLowerCase()){
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
    private ArrayList<String> parseCommands(String line){
        String[] commands = line.replaceAll("[\\[\\]]","").split(", ");
        return new ArrayList<>(List.of(commands));
    }

//    public static void main(String[] args) {
//        List<Animal> an = new ArrayList<>();
//        an.add(new Dog("gasd"));
//        RegistryOfPets rp = new RegistryOfPets(an);
//        RegistryOfPets rp1 = new RegistryOfPets();
//
//        DataBase db = new DataBase(rp);
//        db.saveData();
//        DataBase db1 = new DataBase(rp1);
//        db1.readDataFromFile();
//        System.out.println(db1.getRegistry().getAnimals().toString());
//    }
    public RegistryOfPets getRegistry() {
        return registry;
    }
}
