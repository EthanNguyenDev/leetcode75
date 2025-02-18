package grokkingcodinginterview.pattern.twopointers;

import java.util.Arrays;

public class SortThreeColors {
	public static void main(String[] args) {
		// 0 red, 1 white, 2 blue
		int[] a = { 0, 1, 0, 2, 1, 2, 0, 1, 2, 2 };
		System.out.println(Arrays.toString(sortColors(a)));

		int[] a2 = { 0, 1, 0 };
		System.out.println(Arrays.toString(sortColors(a2)));
	}

	static int[] sortColors(int[] a) {
		int n = a.length;
		int redIndex = 0, whiteIndex = 0;
		int blueIndex = n - 1;

		while (whiteIndex <= blueIndex) {
			// red
			if (a[whiteIndex] == 0) {
				swap(a, whiteIndex, redIndex);
				redIndex++;
				whiteIndex++;
			}
			// white
			else if (a[whiteIndex] == 1) {
				whiteIndex++;
			}
			// blue
			else if (a[whiteIndex] == 2) {
				swap(a, whiteIndex, blueIndex);
				blueIndex--;
			}
		}
		return a;
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
