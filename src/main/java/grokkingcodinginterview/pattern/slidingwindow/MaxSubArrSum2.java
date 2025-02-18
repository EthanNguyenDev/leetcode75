package grokkingcodinginterview.pattern.slidingwindow;

public class MaxSubArrSum2 {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 9, 8, 7, 6, 5, 0 };

		System.out.println(maxSubArrSum(a, 1));
		System.out.println(maxSubArrSum(a, 3));
		System.out.println(maxSubArrSum(a, 5));
		System.out.println(maxSubArrSum(a, 10));

	}

	public static int maxSubArrSum(int[] a, int k) {
		int currentSum = 0;
		int n = a.length;

		for (int i = 0; i < k; i++) {
			currentSum += a[i];
		}
		int maxSum = currentSum;

		for (int i = k; i < n; i++) {
			currentSum = currentSum + a[i] - a[i - k];
			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
		}

		return maxSum;
	}

}
