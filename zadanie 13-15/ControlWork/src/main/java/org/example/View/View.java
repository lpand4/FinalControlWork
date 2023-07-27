package org.example.View;

import org.example.Animals.Animal;
import org.example.Model.RegistryOfPets;

import java.util.List;

public class View {
    public void start_menu(){
        StringBuilder sb = new StringBuilder()
                .append("Добро пожаловать в реестр домашних животных!\n")
                .append("Все дальнейшие действия будут производиться выбором действий. Начнем!!!");
        System.out.println(sb.toString());
    }
    public void menu() {
        StringBuilder sb = new StringBuilder()
                .append("\n1. Просмотреть список животных в реестре.\n")
                .append("2. Завести новое животное.\n")
                .append("3. Увидеть список команд, которое выполняет животное.\n")
                .append("4. Обучить животное новым командам.\n")
                .append("0. Выход.\n");
        System.out.println(sb.toString());
    }
    public void showRegistry(RegistryOfPets rp){
        int count = 1;
        for(Animal animal: rp.getAnimals()){
            System.out.printf("\t%d. \t%s \tName: %s \tCommands: %s\n",
                    count,animal.getType(),animal.getName(),animal.getCommands());
            count++;
        }
        System.out.println("\n");
    }
    public void showRegistry(List<Animal> rp){
        int count = 1;
        for(Animal animal: rp){
            System.out.printf("\t%d. \t%s \tName: %s \tCommands: %s\n",
                    count,animal.getType(),animal.getName(),animal.getCommands());
            count++;
        }
        System.out.println("\n");
    }

    public void showCommands(Animal animal){
        int count = 1;
        System.out.println("Комманды, которые может выполнять "+animal.getName()+":");
        for (String command: animal.getCommandsList()){
            System.out.printf("%d. %s\n",count,command);
            count++;
        }
    }

}
