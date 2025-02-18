package grokkingcodinginterview.pattern.twopointers;

import java.util.Arrays;

public class FindSumOfThree {
	public static void main(String[] args) {
		int[] a = { 3, 7, 1, 2, 8, 4, 5 };
		int[] a2 = { -1, 2, 1, -4, 5, -3 };
		int targetSum = 10;
		int targetSum1 = 21;
		int targetSum2 = -8;

		int[] a3 = { 1, -1, 0 };
		int targetSum3 = -1;

		System.out.println(findSumOfThree(a, targetSum));
		System.out.println(findSumOfThree(a, targetSum1));
		System.out.println(findSumOfThree(a2, targetSum2));
		System.out.println(findSumOfThree(a3, targetSum3));
	}

	static boolean findSumOfThree(int[] a, int sum) {
		Arrays.sort(a); // this use quicksort which has nlogn time complexity
		for (int k = 0; k < a.length; k++) {
			int i = k + 1;
			int j = a.length - 1;
			
			int remaining = sum - a[k];
			while (i < j) {
				if (a[i] + a[j] == remaining) {
					return true;
				}
				if (a[i] + a[j] < remaining) {
					i++;
				}
				if (a[i] + a[j] > remaining) {
					j--;
				}
			}

		}
		return false;
	}
}
