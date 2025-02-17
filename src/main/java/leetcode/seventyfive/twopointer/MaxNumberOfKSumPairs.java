package leetcode.seventyfive.twopointer;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int sum = 5;
		System.out.println(maxOperations(nums, sum)); // 2

		int[] nums2 = { 3, 1, 3, 4, 3 };
		int sum2 = 6;
		System.out.println(maxOperations(nums2, sum2)); // 1

		int[] nums3 = { 3, 5, 1, 5 };
		int sum3 = 2;
		System.out.println(maxOperations(nums3, sum3)); // 0

	}

	static int maxOperations(int[] nums, int k) {
		Map<Integer, Integer> appearance = new HashMap<>();
		int result = 0;

//		for (int num: nums) {
//			appearance.put(num, appearance.getOrDefault(num, 0) + 1);
//		}
//
//		for (int num: nums) {
//			int remaining = k - num;
//
//			int noOfAppearance = appearance.getOrDefault(remaining, 0);
//			if (noOfAppearance > 0) {
//				appearance.put(remaining, noOfAppearance - 1);
//				appearance.put(num, appearance.get(num) - 1);
//				if (appearance.get(num) >= 0) {
//					result++;
//				}
//			}
//		}
		
		for (int num : nums) {
			int remaining = k - num;

			int noOfAppearance = appearance.getOrDefault(remaining, 0);
			if (noOfAppearance > 0) {
				result++;
				appearance.put(remaining, noOfAppearance - 1);
			} else {
				appearance.put(num, appearance.getOrDefault(num, 0) + 1);
			}
		}

		return result;
	}
}
