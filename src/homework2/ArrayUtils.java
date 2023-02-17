package homework2;

import java.util.Random;

/**
 * Утилитный класс для рбаоты с целочисленным массивом
 */
public class ArrayUtils {

    /**
     * Метод генерации целочисленного массива
     *
     * @param length размерность массива
     * @return сгенерированный массив
     */
    public static int[] generateIntArray(int length) {
        Random random = new Random();
        int[] result = new int[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(-10, 10);
        }
        return result;
    }

    /**
     * Метод для вывода массива
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) return;
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Метод для сортировки массива, для пользовательского вызова
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        int length = arr.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            sort(arr, i, length);
        }

        for (int i = length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            sort(arr, 0, i);
        }
    }

    /**
     * Внутренний механизм сортировки массива
     *
     * @param arr        сортируемый массив
     * @param startIndex индекс с которого начинаем собирать кучу
     * @param endIndex   индекс последнего не отсортированного элемента в массива
     */
    private static void sort(int[] arr, int startIndex, int endIndex) {
        int indexMax = startIndex;
        int leftChildIndex = startIndex * 2 + 1;
        int rightChildIndex = startIndex * 2 + 2;
        if (leftChildIndex < endIndex && arr[leftChildIndex] > arr[indexMax]) {
            indexMax = leftChildIndex;
        }
        if (rightChildIndex < endIndex && arr[rightChildIndex] > arr[indexMax]) {
            indexMax = rightChildIndex;
        }
        if (indexMax != startIndex) {
            int temp = arr[startIndex];
            arr[startIndex] = arr[indexMax];
            arr[indexMax] = temp;
            sort(arr, indexMax, endIndex);
        }
    }
}
