package algorithm.sort.selectionsort;

import java.util.Arrays;

public class SelectionSort {
	// find the smallest number & swap it to the beginning in every iteration
	public static void main(String[] args) {
//		int[] arr = { 20, 50, 60, 80, 12, 24, 7, 55, 90 };
		int[] arr = { 34, 8, 64, 51, 32, 21 };
		selectionSort(arr);
//		System.out.println(Arrays.toString(selectionSort(arr)));
	}
	
	public static int[] selectionSort(int[] a) {
		
//		for (int i = 0; i < a.length; i++) {
//			int min = a[i];
//			for (int j = i+1; j < a.length; j++) {
//				if (a[j] < min) {
//					int temp = a[j];
//					a[j] = min;
//					min = temp;
//				}
//			}
//			a[i] = min;
//		}
		
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i+1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
			System.out.println(Arrays.toString(a));
		}
		
		return a;
	}

}
