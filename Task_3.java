import java.util.*;

public class Task_3 {
    public void heapSort(int[] arr) {
        int n = arr.length;

        // строим max-кучу
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // извлекаем элементы из max-кучи в порядке убывания размера
        for (int i = n - 1; i >= 0; i--) {
            // перемещаем текущий корень на конец массива
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // рекурсивно уменьшаем размер max-кучи и выполняем heapify, чтобы восстановить свойство max-кучи
            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i; // инициализируем largest как корень кучи
        int left = 2 * i + 1; // левый = 2i + 1
        int right = 2 * i + 2; // правый = 2i + 2

        // если левый дочерний элемент больше корня
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // рекурсивно heapify, чтобы обработать subtree, на которое изначально произошла перестановка
            heapify(arr, n, largest);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        Task_3 heapSort = new Task_3();
        heapSort.heapSort(arr);
        System.out.println("Отсортированный массив:");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }
}
