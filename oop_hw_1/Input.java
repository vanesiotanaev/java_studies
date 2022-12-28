package oop_hw_1;

import java.util.Scanner;

public class Input {
  public int getNumber() {
    Scanner scanner = new Scanner(System.in);
    int num;
    System.out.print("Введите цифру: ");
    num = scanner.nextInt();

    return num;
  }

  public String getStaffInfo() {
    Scanner scanner = new Scanner(System.in);
    String info;
    System.out.print("Введите данные, которые Вы хотите найти: ");
    info = scanner.nextLine();

    return info;
  }
}