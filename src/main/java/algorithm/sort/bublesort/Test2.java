package algorithm.sort.bublesort;

import java.util.Arrays;

public class Test2 {
	public static void main(String[] args) {

		int[] arr = { 34, 8, 64, 51, 32, 21 };
		int len = arr.length;
		for (int i = 0; i < len; ++i) {
			for (int j = 0; j < len - 1 - i; ++j) {
				if (arr[j] > arr[j + 1]) {
//					swap(arr, j, j + 1);

					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}

	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
