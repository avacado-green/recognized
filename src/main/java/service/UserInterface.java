package service;

import model.FamilyTree;
import model.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class UserInterface {
    private FamilyTree<Person> familyTree;
    private FamilyTreeService<Person> familyTreeService;
    private Scanner scanner;

    public UserInterface(FamilyTree<Person> familyTree, FamilyTreeService<Person> familyTreeService) {
        this.familyTree = familyTree;
        this.familyTreeService = familyTreeService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Введите команду (add, sortByName, sortByBirthDate, exit):");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    addPerson();
                    break;
                case "sortByName":
                    familyTreeService.sortByName(Comparator.comparing(Person::getName));
                    break;
                case "sortByBirthDate":
                    familyTreeService.sortByBirthDate(Comparator.comparing(Person::getBirthDate));
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неизвестная команда.");
            }
        }
    }

    private void addPerson() {
        try {
            System.out.println("Введите имя:");
            String name = scanner.nextLine();
            System.out.println("Введите дату рождения (yyyy-mm-dd):");
            String birthDateString = scanner.nextLine();
            Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateString);

            Person person = new Person(name, birthDate, null, null);
            familyTree.addMember(person);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты.");
        }
    }
}

