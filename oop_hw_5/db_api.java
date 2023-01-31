package oop_hw_5;

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
  
    public ArrayList findExperience() {
      ArrayList<Integer> array = new ArrayList<>();
      
      for (int i = 0; i < db.staff.size(); i++) {
        Staff staff = db.staff.get(i);
        array.add(staff.experience);
      }
  
      return array;
    }
  
    public void searchExperience(int experience) {
      ArrayList<Integer> a = findExperience();
      for (int i = 0; i < a.size(); i++) {
        if (a.get(i) >= experience) {
          System.out.println(getAllInfo(i + 1));
        }
      }
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
      Staff staff1 = new Staff(1, "Kostya", "Kovalev", "+79263521243", "Novo-Sadovaya 17", 5);
      Staff staff2 = new Staff(2, "Mihail", "Denisov", "+79811240952", "Samarskaya 9", 3);
      Staff staff3 = new Staff(3, "Denis", "Romanov", "+79120345693", "Leninskaya 12", 10);
      Staff staff4 = new Staff(4, "Konstantin", "Polev", "+79213531305", "Michurina 90", 8);
      Staff staff5 = new Staff(5, "Irina", "Matveenko", "+79211235123", "Gagarina 7", 7);
      Staff staff6 = new Staff(6, "Robert", "Novikov", "+79251254612", "Pushkina 15", 11);
      Staff staff7 = new Staff(7, "Vasiliy", "Krasnov", "+79812453685", "Lenina 25", 2);
  
      db.staff.add(staff1);
      db.staff.add(staff2);
      db.staff.add(staff3);
      db.staff.add(staff4);
      db.staff.add(staff5);
      db.staff.add(staff6);
      db.staff.add(staff7);
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
    int experience;
    
    public Staff(int id, String firstName, String lastName, String telephone, String addres, int experience) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.telephone = telephone;
      this.adress = addres;
      this.experience = experience;
    }
  
  }
  
