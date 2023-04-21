package gb_hw_2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FractionalNumber {
    public static float getFractionalNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        float number = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Введите дробное число: ");
                number = scanner.nextFloat();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: неверный формат числа. Попробуйте снова.");
                scanner.nextLine();
            }
        }
        return number;
    }

    public static void main(String[] args) {
        float inputNumber = getFractionalNumberFromUser();
        System.out.println("Введенное число: " + inputNumber);
    }
}