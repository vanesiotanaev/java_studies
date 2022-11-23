import java.util.Scanner; 
// для получения данных из терминала

// Создали класс, одноименный с нашим файлом, в нем один метод main обязательно. Этот метода принимает массив строк на вход.
public class lection_1 {
    public static void main(String[] args) {
        String s = null;

        String s1 = "qwerty";
        System.out.println(s1.charAt(1));

        short age = 10;
        int salary = 123456;
        float f = 123.45f;
        double d1 = 21.3;
        float d3 = 21.3f;
        double d4 = 21.3f;
        int d2 = 3;

        System.out.println(d1/d2);
        System.out.println(d3/d2);
        System.out.println(d4/d2);

        // Постфиксный и префиксный инкременты и декременты.
        System.out.println("Постфиксный и префиксный инкременты и декременты");
        int a = 123;
        System.out.println(a++);
        System.out.println(++a);

        // Неявная типизация
        System.out.println("Неявная типизация");
        var i = 123;

        System.out.println(i);

        //Произошло неявное преобразование
        char ch = 123;

        boolean b = true && false;

        System.out.println(b);

        System.out.println(ch);

        System.out.println(age);

        System.out.println(salary);

        System.out.println(f);

        System.out.println(getType(ch));

        System.out.println(Integer.MAX_VALUE);

        // Одномерные массивы
        System.out.println("Одномерные массивы");
        int[] arr = new int[10];
        System.out.println(arr.length);
        arr = new int[] {1, 2, 3, 4, 5};
        System.out.println(arr.length);

        // Многомерные массивы
        System.out.println("Многомерные массивы");

        int[] arr1[] = new int[3][5];
        for (int[] line: arr1) {
            for (int item: line) {
                System.out.printf("%d", item);
            }
            System.out.println();
        }
        // Получение данных из терминала

        System.out.println("Получение данных из терминала");
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("name: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!", name);
        iScanner.close();

    }
    
    

    static String getType(Object o) {
        return o.getClass().getSimpleName();
    }
}

//Типы данных и переменных
//Ссылочные типы (относ. к классам. Пока что только массивы.)
//Примитивные (boolean, int, short, long, float, double, Char и т.д.)

