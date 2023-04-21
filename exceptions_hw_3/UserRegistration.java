package exceptions_hw_3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество Дата_рождения Номер_телефона Пол (разделенные пробелом): ");
        String input = scanner.nextLine();
        scanner.close();

        String[] data = input.split(" ");
        if (data.length != 6) {
            System.out.println("Ошибка: введено неправильное количество данных.");
            return;
        }

        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];

        LocalDate birthdate;
        try {
            birthdate = LocalDate.parse(data[3], java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка: неверный формат даты рождения.");
            return;
        }

        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(data[4]);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: номер телефона должен быть целым числом без форматирования.");
            return;
        }

        String gender = data[5];
        if (!gender.equals("f") && !gender.equals("m")) {
            System.out.println("Ошибка: неверное значение пола. Допустимые значения: 'f' или 'm'.");
            return;
        }

        try {
            FileWriter fileWriter = new FileWriter(surname + ".txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print("<" + surname + ">");
            printWriter.print("<" + name + ">");
            printWriter.print("<" + patronymic + ">");
            printWriter.print("<" + birthdate + ">");
            printWriter.print("<" + phoneNumber + ">");
            printWriter.print("<" + gender + ">");
            printWriter.println(); 
            printWriter.close();
            System.out.println("Данные успешно записаны в файл: " + surname + ".txt");
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}