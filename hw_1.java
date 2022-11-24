//Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
// Пример 1: а = 3, b = 2, ответ: 9
// Пример 2: а = 2, b = -2, ответ: 0.25
// Пример 3: а = 3, b = 0, ответ: 1
// Пример 4: а = 0, b = 0, ответ: не определено
// Пример 5
// входные данные находятся в файле input.txt в виде
// b 3
// a 10
// Результат нужно сохранить в файле output.txt
// 1000

import java.io.*;

public class hw_1 {
    public static void main(String[] args) {
        // Вводные данные.
        int a_input = 10;
        int b_input = 3;
        String input_path = "input.txt";
        // Создаем файл, исходя из вводных.
        create_file(a_input, b_input);
        // Считываем файл в массив строк.
        String[] values_array = read_file(input_path);
        // Конвертируем в int каждый элемент полученного массива строк.
        int a_output = Integer.valueOf(values_array[1]);
        int b_output = Integer.valueOf(values_array[0]);
        int power = a_input;
        // Основная логика.
        System.out.print("a: ");
        System.out.println(a_output);
        System.out.print("b: ");
        System.out.println(b_output);

        if (b_output > 0) {
            for (int i = 0; i < b_output-1; i++) {
                a_output = a_output * power;
            }
            System.out.print("Answer: ");
            System.out.print(a_output);
        }
        else {
            if (b_output == 0 && a_output > 0) {
                a_output = 1;
                System.out.print("Answer: ");
                System.out.print(a_output);
            }
            if (a_output > 0 && b_output < 0) {
                b_output = b_output * (-1);
                for (int i = 0; i < b_output-1; i++) {
                    a_output = a_output * power;
                }
                float answer = a_output;
                answer = 1/answer;
                System.out.print("Answer: ");
                System.out.print(answer);
            }
            if (a_output == 0 && b_output == 0) {
                System.out.print("Answer: ");
                System.out.print("Не опрeделено!");
            }
        }       
    }
    // Метод для создания файла и записи в файл.
    public static void create_file(Integer a, Integer b) {
        String b_string = Integer.toString(b);
        String a_string = Integer.toString(a);

        try (FileWriter fw = new FileWriter("input.txt", false)) {
            fw.write("b " + b_string);
            fw.append('\n');
            fw.append("a " + a_string);
            fw.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    // Метод считывания файла в массив строк.
    public static String[] read_file(String path) {
        String[] values = new String[2];
        int count = 0;
        try {
            File file = new File(path);
            //создаем объект FileReader для объекта File.
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания.
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку.
            String line = reader.readLine();
            while (line != null) {
                values[count] = line;
                // считываем остальные строки в цикле.
                line = reader.readLine();
                count++;
            }
            reader.close();
            array_parse(values);
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        return values;
    }
    // Метод вывода массива в терминал (на всякий случай).
    public static void array_output(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] +';');
        }   
    }
    // Метод для удаления ненужных символов из каждого элемента массива строк.
    public static String[] array_parse(String[] array) {
        for (int i = 0; i < array.length; i++) {
            StringBuffer sb = new StringBuffer(array[i]);
            for (int j = 0; j < sb.length(); j++) {
                if (Character.isDigit((char)sb.charAt(j)) == false && (char)sb.charAt(j) != '-') {
                    sb.delete(j, j+2);
                }
            }
            array[i] = sb.toString();
        }
        return array;
    }
}

