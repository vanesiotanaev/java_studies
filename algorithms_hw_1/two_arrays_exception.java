package algorithms_hw_1;

import java.util.*;

public class two_arrays_exception {

    public static void main(String[] args) {
        int[] firstArray ={1, 3, -9, 20, 9};
        int[] secondArray = {-31, 9, 19, -8};

        int[] resultArray = diffArrays(firstArray, secondArray);
        System.out.println(Arrays.toString(resultArray));
    }

    public static int[] diffArrays(int[] arr1, int[] arr2) throws RuntimeException {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не равны.");
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] - arr2[i];
        }
        return result;
    }

    public static int[] divArrays(int[] arr1, int[] arr2) throws RuntimeException {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не равны.");
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] / arr2[i];
        }
        return result;
    }
}
