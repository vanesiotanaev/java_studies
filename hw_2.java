// Реализовать алгоритм сортировки массива слиянием

public class hw_2 {

    public static void main(String[] params) {
        int[] unsortedArray = new int[] {10, 6, 8, 5, 7, 3, 4};
        System.out.println(arrayToString(unsortedArray));
        int[] sortedArray = mergeSort(unsortedArray);
        System.out.println(arrayToString(sortedArray));
    }

    public static int[] mergeSort(int[] array) {
        int[] temp;
        int[] currentOne = array;
        int[] currentTwo = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentOne, i, currentOne, i + size, currentTwo, i, size);
            }

            temp = currentOne;
            currentOne = currentTwo;
            currentTwo = temp;

            size = size * 2;

            System.out.println(arrayToString(currentOne));
        }
        return currentOne;
    }

    private static void merge(int[] source1, int source1Start, int[] source2, int source2Start, int[] destination,
                              int destinationStart, int size) {
        int index1 = source1Start;
        int index2 = source2Start;

        int src1End = Math.min(source1Start + size, source1.length);
        int src2End = Math.min(source2Start + size, source2.length);

        if (source1Start + size > source1.length) {
            for (int i = source1Start; i < src1End; i++) {
                destination[i] = source1[i];
            }
            return;
        }

        int iterationCount = src1End - source1Start + src2End - source2Start;

        for (int i = destinationStart; i < destinationStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || source1[index1] < source2[index2])) {
                destination[i] = source1[index1];
                index1++;
            } else {
                destination[i] = source2[index2];
                index2++;
            }
        }
    }
    // Красивый вывод
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
