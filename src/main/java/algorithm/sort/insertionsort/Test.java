package algorithm.sort.insertionsort;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {

		int[] arr = { 34, 8, 64, 51, 32, 21 };
//		System.out.println("Original Array: " + Arrays.toString(arr));
		insertionSort(arr);
//		System.out.println("Sorted Array: " + Arrays.toString(arr));
	}

	public static void insertionSort(int[] array) {
		int n = array.length;
		int temp = 0;
		int j = 0;
		for (int i = 1; i < n; ++i) {
			temp = array[i];
			j = i;
			while (j > 0 && temp < array[j - 1]) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = temp;
			System.out.println(Arrays.toString(array));
		}
	}
}
