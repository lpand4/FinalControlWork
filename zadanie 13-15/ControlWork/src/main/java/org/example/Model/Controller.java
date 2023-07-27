package org.example.Model;

import org.example.Database.DataBase;
import org.example.View.View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    Scanner sc = new Scanner(System.in);
    View v = new View();
    RegistryOfPets rp;
    DataBase db = new DataBase(rp);


    public Controller() {
    }

    public void start(){
        this.rp = db.readDataFromFile();
        v.start_menu();
        String choise;
        try {
            do {
                v.menu();
                choise = sc.nextLine();
                switch (choise) {
                    case "1":
                        //Просмотреть список животных в реестре
                        v.showRegistry(rp);
                        break;
                    case "2":
                        //Завести новое животное
                        rp.addNewAnimal();
                        break;
                    case "3":
                        //Увидеть список команд, которое выполняет животное
                        v.showCommands(rp.seeCommands());
                        break;
                    case "4":
                        //Обучить животное новым командам
                        rp.teachNewCommand();
                        break;
                    case "0":
                        //Выход.
                        System.out.println("Всего доброго");
                        db.saveData(this.rp);
                        break;
                    default:
                        System.out.println("Введенное значение не подходит.");
                        break;
                }
            } while (!choise.equals("0"));
        } catch (InputMismatchException a) {
            System.out.println("Введено неверное значение!");
        }
    }
}
