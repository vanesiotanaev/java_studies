package oop_hw_1;

import java.util.ArrayList;

class Infrastructure {
  public Infrastructure() {
    init();
  }

  Db db;

  public Db getDb() {
    return db;
  }

  public String getAllInfo(int idStaff) {
    Staff staff = db.staff.get(idStaff - 1);

    return String.format("id: %s, First Name: %s, Last Name: %s, Phone Number: %s, Adress: %s, Experience: %s",
        staff.id,
        staff.firstName,
        staff.lastName,
        staff.telephone,
        staff.adress,
        staff.experience);

  }

  public void search(String word) {
    ArrayList<String> searchResult = new ArrayList<>();
    for (int i = 1; i <= db.staff.size(); i++) {
      String res = getAllInfo(i);
      boolean check = res.contains(word);
      if (check == true) {
        searchResult.add(res + "\n");
        System.out.println(getAllInfo(i));
      }
    }
  }

  public void allStaff() {
    for (int i = 1; i <= db.staff.size(); i++) {
      System.out.println(getAllInfo(i));
    }
  }

  Db init() {
    db = new Db();
    Staff staff1 = new Staff(1, "Ivan", "Tanaev", "+79277351211", "Sadovaya 1", "3 years");
    Staff staff2 = new Staff(2, "John", "Stones", "+79991112233", "Molodogvardeyskaya 9", "3 years");
    Staff staff3 = new Staff(3, "Ben", "Foster", "+79175556677", "Leninskaya 151", "5 years");
    Staff staff4 = new Staff(4, "Michael", "Scott", "+79151234567", "Scranton", "20 years");
    Staff staff5 = new Staff(5, "Arnold", "Schwarzenegger", "123456789", "California", "1 year");

    db.staff.add(staff1);
    db.staff.add(staff2);
    db.staff.add(staff3);
    db.staff.add(staff4);
    db.staff.add(staff5);

    return db;
  }
}

class Db {
  ArrayList<Staff> staff = new ArrayList<>();

}

class Staff {
  int id;
  String firstName;
  String lastName;
  String telephone;
  String adress;
  String experience;

  public Staff(int id, String firstName, String lastName, String telephone, String addres, String experience) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.adress = addres;
    this.experience = experience;
  }
}