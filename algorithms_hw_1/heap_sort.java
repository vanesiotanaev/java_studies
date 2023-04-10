package algorithms_hw_1;

import java.util.Arrays;

public class heap_sort {
    
    public void sort(int[] arr) {
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Функция для перевода поддерева с корнем i в кучу максимального размера n
    void heapify(int[] arr, int n, int i) {
        int largest = i; // инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Продолжаем heapify для измененного поддерева
            heapify(arr, n, largest);
        }
    }
    
    // пример использования
    public static void main(String args[]) {
        int arr[] = {14, 10, 15, 1, 0, 17};
        heap_sort heapSort = new heap_sort();
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}