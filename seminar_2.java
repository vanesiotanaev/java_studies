// Задача 1: Задайте массив из 12 элементов,
    // заполненный случайными числами из промежутка [-9, 9].
    // Найдите сумму отрицательных и положительных
    // элементов массива.

import java.util.Scanner; 

public class seminar_2 {
    public static void main(String[] args) {
        int quantity = input_quantity();
        int[] array = create_array(quantity);
    }

    public static int input_quantity() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        boolean is_correct = false;
        int quantity = 0;
        while (!is_correct) {
            String input = iScanner.nextLine();
            try {
                quantity = Integer.parseInt(input);
                is_correct = true;
            } catch (Exception ex) {
                System.out.println("Ошибка ввода");
                System.out.print("Введите количество элементов массива: ");
            }
        }
        iScanner.close();
        return quantity;
    }

    public static int[] create_array(int size) {
        int[] array = new int[size];
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите минимальное возможное значение: ");
        boolean is_correct = false;
        int min;
        while (!is_correct) {
            String input = iScanner.nextLine();
            try {
                min = Integer.parseInt(input);
                is_correct = true;
            } catch (Exception ex) {
                System.out.println("Ошибка ввода");
                System.out.print("Введите минимальное возможное значение: ");
            }
        iScanner.close();
        return array;
    }
    
}}

