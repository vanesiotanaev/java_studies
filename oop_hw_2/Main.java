package oop_hw_2;

public class Main {
    public static void main(String[] args) {
        Human.addHuman("Tanaev", 25, Gender.Man);
        Human.addHuman("Odinson", 20, Gender.Woman);
        Human.addHuman("Swanson", 36, Gender.Man);
        Human.addHuman("Shephard", 29, Gender.Woman);
        Human.addHuman("Carbonell", 47, Gender.Man);
        Human.addHuman("Hayek", 38, Gender.Woman);
        Human.addHuman("Giacchino", 49, Gender.Man);
        Human.addHuman("Howard", 47, Gender.Woman);

        Human.printHumanList();
        System.out.println(Communications.getHumans());

        // проверяем на поиск элемента в Human
        Communications.addTypeRelationship("Иванов", TypeRelationship.Husband, "Иванова");
    }
}
