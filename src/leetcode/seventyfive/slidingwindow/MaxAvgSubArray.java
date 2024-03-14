package leetcode.seventyfive.slidingwindow;

import java.util.Iterator;

public class MaxAvgSubArray {
	public static void main(String[] args) {
		int[] nums = { 1, 12, -5, -6, 50, 3 };
		int k = 4;
		System.out.println(findMaxAverage(nums, k)); // 12.75

		int[] nums2 = { 5 };
		int k2 = 1;
		System.out.println(findMaxAverage(nums2, k2)); // 5

		int[] nums3 = { 0, 4, 0, 3, 2 };
		int k3 = 1;
		System.out.println(findMaxAverage(nums3, k3)); // 4.0

		int[] nums4 = { 4, 2, 1, 3, 3 };
		int k4 = 2;
		System.out.println(findMaxAverage(nums4, k4)); // 3.0
	}

	public static double findMaxAverage(int[] nums, int k) {
		int n = nums.length;
		double result = 0;

		// init
		for (int i = 0; i < k; i++) {
			result += nums[i];
		}

		// sliding
		double temp = result;
		for (int i = 0; i < n - k; i++) {
			temp = temp - nums[i] + nums[i + k];
			if (temp > result) {
				result = temp;
			}
		}
		return result / k;
	}
}
