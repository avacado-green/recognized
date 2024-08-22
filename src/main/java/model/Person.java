package model;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private String name;
    private Date birthDate;
    private Person mother;
    private Person father;

    public Person(String name, Date birthDate, Person mother, Person father) {
        this.name = name;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", mother=" + (mother != null ? mother.getName() : "null") +
                ", father=" + (father != null ? father.getName() : "null") +
                '}';
    }
}

