package algorithm.sort.quicksort;

public class QuickSortLastElementAsPivot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = { 20, 50, 60, 80, 12, 24, 7, 55, 90 };

		quickSort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void quickSort(int[] arr, int start, int end) {

//		if (start >= end)
//			return;
//
//		int pivot = partition(arr, start, end);
//		quickSort(arr, start, pivot - 1);
//		quickSort(arr, pivot + 1, end);

		if (start < end) {
			int pivotIndex = partition(arr, start, end);
			quickSort(arr, start, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, end);
		}

	}

	public static int partition(int[] arr, int start, int end) {

//		int pivot = arr[end];
//		int i = start - 1;
//
//		for (int j = start; j < end; j++) {
//			if (arr[j] < pivot) {
//				i++;
//				int temp = arr[i];
//				arr[i] = arr[j];
//				arr[j] = temp;
//			}
//		}
//		i++;
//		
//		int temp = arr[i];
//		arr[i] = arr[end];
//		arr[end] = temp;
//		return i;
		
		// using middle  element as pivot
		int mid = start + (end - start) / 2;
		int pivot = arr[mid];

		while (start <= end) {
			while (arr[start] < pivot) {
				start++;
			}

			while (arr[end] > pivot) {
				end--;
			}

			if (start <= end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}
		return start;

	}

}
