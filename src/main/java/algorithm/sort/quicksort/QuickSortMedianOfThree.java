package algorithm.sort.quicksort;

import java.util.Arrays;

public class QuickSortMedianOfThree {
	public static void main(String[] args) {

//		int[] array = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
//		int[] array = {5, 1, 4, 2, 3, 9, 7, 6, 8} ;
//		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		int[] array =  { 7, 2, 9, 4, 3, 7, 6, 1 };

		qsort(array, 0, array.length - 1);

		System.out.println(Arrays.toString(array));

	}

	private static void qsort(int[] keyArray, int lower, int upper) {
		int i, j; // these are the moving pointers into the array
		if (upper <= lower) {
			//System.out.println("Returning " + upper + " " + lower);
			return;
		}
		else {
			System.out.println("Array before " + Arrays.toString(keyArray));
			int pivotPos = getMedianIndex(keyArray, lower, upper);
//			int pivotPos = keyArray.length - 1;
//			int pivotPos = 0;
			int pivot = keyArray[pivotPos];
			System.out.println("Pivot position " + pivotPos + ", Pivot value " + pivot);
			
			swap(keyArray, pivotPos, upper);

			i = lower;
			j = upper - 1;
			while (true) {
				while (i <= j && keyArray[i] < pivot)
					i++;
				while (i <= j && keyArray[j] > pivot)
					j--;
				if (i <= j) {
					swap(keyArray, i++, j--);
				} else
					break;
			}
			swap(keyArray, upper, i);

//			if (lower <= lowPtr) {
//				System.out.println("...Left array: " + Arrays.toString(Arrays.copyOfRange(keyArray, lower, lowPtr)));
//			}
//			System.out.println("...Pivot segment: " + keyArray[lowPtr]);
//			if (lowPtr != upper) {
//				System.out
//						.println("...Right array: " + Arrays.toString(Arrays.copyOfRange(keyArray, lowPtr + 1, upper)));
//			}
			System.out.println("...Array after iteration " + Arrays.toString(keyArray));

			qsort(keyArray, lower, i - 1);
			qsort(keyArray, i + 1, upper);
		}
	}

	public static int getMedianIndex(int[] arr, int start, int stop) {
		int x = arr[start];

		int m = (start + stop) / 2;
		int y = arr[m];

		int z = arr[stop];
		if ((x - y) * (z - x) >= 0) // x >= y and x <= z OR x <= y and x >= z
			return start;
		else if ((y - x) * (z - y) >= 0) // y >= x and y <= z OR y <= x and y >= z
			return m;
		else
			return stop;
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
