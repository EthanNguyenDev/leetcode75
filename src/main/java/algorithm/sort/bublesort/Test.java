package algorithm.sort.bublesort;

import java.util.Arrays;

public class Test {
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            // Printing the array at each iteration of the outer loop
            System.out.println("Array after iteration " + (i + 1) + ": " + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] array = {34, 8, 64, 51, 32, 21};
//        System.out.println("Original Array: " + Arrays.toString(array));
        bubbleSort(array);
//        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}