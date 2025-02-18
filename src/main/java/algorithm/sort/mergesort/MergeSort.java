package algorithm.sort.mergesort;

public class MergeSort {
	public static void main(String[] args) {

		int[] arr = { 20, 50, 60, 80, 12, 24, 7, 55, 90 };

		mergeSort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void mergeSort(int[] array) {
		int length = array.length;
		if (length <= 1) return;
		
		int middle = length/2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length - middle];
		int i = 0, j = 0;
		
		for (; i < array.length; i++) {
			if (i < middle) {
				leftArray[i] = array[i];
			} else {
				rightArray[j] = array[i];
				j++;
			}
		}
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, array);
	}

	public static void merge(int[] leftArray, int[] rightArray, int[] array) {

		int i = 0, l = 0, r = 0;
		while (l < leftArray.length && r < rightArray.length) {
			if (leftArray[l] < rightArray[r]) {
				array[i] = leftArray[l];
				i++;
				l++;
			} else {
				array[i] = rightArray[r];
				i++;
				r++;
			}
		}
		while (l < leftArray.length) {
			array[i] = leftArray[l];
			i++;
			l++;
		}

		while (r < rightArray.length) {
			array[i] = rightArray[r];
			i++;
			r++;
		}

	}
}
