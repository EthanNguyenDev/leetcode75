package algorithm.sort.insertionsort;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
//		int[] arr = { 20, 50, 60, 80, 12, 24, 7, 55, 90 };
		int[] arr = { 34, 8, 64, 51, 32, 21 };
		insertionSort(arr);
//		System.out.println(Arrays.toString(insertionSort(arr)));
	}
	
	public static int[] insertionSort(int[] a) {
		
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i - 1;
			
			for (; j >=0 && a[j] > temp; j--) {
				a[j+1] = a[j];
			}
			a[j+1] = temp;
			System.out.println(Arrays.toString(a));
		}
		
		return a;
	}

}
