package gb_hw_2;

public class FindMistake {
    public static void main(String[] args) {
        try {
            int d = 0; 
            int[] intArray = new int[9]; // Объявление и инициализация массива intArray
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
        
    }
}