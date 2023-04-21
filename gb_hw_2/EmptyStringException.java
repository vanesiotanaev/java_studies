package gb_hw_2;

import java.util.*;

public class EmptyStringException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        scanner.close();

        try {
            if (input.isEmpty()) { // Проверяем, является ли введенная строка пустой
                throw new Exception("Пустые строки вводить нельзя"); // Выбрасываем исключение
            } else {
                System.out.println("Вы ввели: " + input);
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage()); // Выводим сообщение об ошибке
        }
    }
}
