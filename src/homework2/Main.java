package homework2;

public class Main {
    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateIntArray(10);
        //int[] arr = {-5, -4, 8, 6, 7, -4, 0, -1, 7, -7};
        ArrayUtils.printArray(arr);
        ArrayUtils.heapSort(arr);
        ArrayUtils.printArray(arr);
    }
}
