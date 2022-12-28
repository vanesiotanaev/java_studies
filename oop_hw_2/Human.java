package oop_hw_2;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private int age;
    private Gender gender;
    protected static List<Human> humans = new ArrayList<Human>();

    public Human(String name, int age, Gender gender) {
        setName(name);
        setAge(age);
        setGender(gender);

    }

    public Human(List<Human> humans) {
        setHumans();
    }

    public static void addHuman(String name, int age, Gender gender) {
        Human piple = new Human(name, age, gender);
        humans.add(piple);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static List<Human> getHumans() {
        return humans;
    }

    public static void setHumans() {
        Human.humans = humans;
    }

    public static void printHumanList() {
        for (Object o : getHumans()) {
            System.out.println(o);
        }
    }

    @Override
    public String toString() {
        return name + ' ' + age + ' ' + gender;
    }
}