package algorithm.sort.bublesort;

import java.util.Arrays;

public class BubbleSort {
	// the max will bubble up to the right index for each iteration
	public static void main(String[] args) {
//		int[] arr = { 20, 50, 60, 80, 12, 24, 7, 55, 90 };
		int[] arr = { 34, 8, 64, 51, 32, 21 };
		System.out.println(Arrays.toString(bubbleSort(arr)));

	}

	public static int[] bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a));
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}

}
