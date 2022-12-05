// На вход некоторому исполнителю подаётся четыре числа (a, b, c, d).

// У исполнителя есть две команды
// - команда 1 (к1): увеличить в с раз, а умножается на c
// - команда 2 (к2): увеличить на d , к a прибавляется d
// написать программу, которая выдаёт общее количество возможных преобразований a в b
// набор команд, позволяющий число a превратить в число b или сообщить, что это
// невозможно

// Пример 1: а = 1, b = 7, c = 2, d = 1
// ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1.
// Пример 2: а = 11, b = 7, c = 2, d = 1
// ответ: нет решения.
// *Подумать над тем, как сделать вывод маршрута (хотя бы одного)

// Тестовые данные

// a: 2 b: 7 c: 2 d: 1 -> 3
// a: 3 b: 27 c: 3 d: 2 -> 6
// a: 30 b: 345 c: 5 d: 6 -> 0
// a: 30 b: 345 c: 2 d: 1 -> 7047
// a: 22 b: 333 c: 3 d: 1 -> 467
// a: 55 b: 555 c: 5 d: 2 -> 30
// a: 22 b: 2022 c: 11 d: 56 -> 0
// a: 22 b: 2022 c: 11 d: 10 -> 18
// a: 22 b: 2022 c: 3 d: 1 -> 763827
// a: 22 b: 20220 c: 3 d: 1 -> 535173226980
// a: 1 b: 1111 c: 2 d: 1 -> 3990330794
// a: 1 b: 11111 c: 2 d: 1 -> 606408167570737286

public class hw_3 {
    public static void main(String[] args) {
        int startValue = 22;
        int destValue = 2022;
        int plusValue = 56;
        int multiplier = 11;
        
        if (startValue >= destValue) {
            System.out.print("Ошибка во вводных данных!");
        } else {
            // Проверка, чтобы plusValue (то, что мы прибавляем) была больше, чем multiplier (то, на что умножаем)
            if (plusValue <= multiplier) {
                long[] array = CreateArray(destValue, startValue, plusValue, multiplier);
                LongArrayOutput(array);

                System.out.print("Количество возможных путей: ");
                System.out.println(array[destValue]);
                // Иначе количество возможных путей до destValue будет равняться нулю.
                } else {
                    System.out.print("Количество возможных путей: 0");
                }   
            }
        }
        

        // Логика
        public static long[] CreateArray(int size, int startValue, int plusValue, int multiplier) {
            // Создаем массив такой, чтобы элементов в нем было больше, чем наша destValue, на единицу.
            // По умолчанию заполняем его нулями.
            long[] array = new long[size+1];
            for (int i = 0; i < array.length; i++) {
                array[i] = 0;
            }
            // Элемент с индексом startValue всегда равен единице.
            // А его индекс - наше начальное значение.
            array[startValue] = 1;
            // Чтобы получить каждый следующий элемент, нужно:
            for (int i = startValue+1; i < array.length; i++) {
                // ...проверить, делится ли индекс элемента на multiplier без остатка.
                if (i % multiplier != 0) {
                    // если нет, то вычитаем из индекса plusValue.
                    array[i] = array[i-plusValue];
                } else {
                    // иначе вычитаем из индекса plusValue и прибавляем к этому частное индекс/multiplier.
                    array[i] = array[i-plusValue] + array[i/multiplier];
                }
            }
            return array;
        }

        // Метод для вывода массива, где тип элементов - long.
        public static void LongArrayOutput(long[] array) {
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                if (i < array.length-1) {
                    System.out.print(array[i] + "; ");
                } else {
                    System.out.print(array[i]);
                }
            }
            System.out.println("]");   
        }
    }

