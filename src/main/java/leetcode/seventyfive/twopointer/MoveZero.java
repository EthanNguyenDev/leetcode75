package leetcode.seventyfive.twopointer;

import java.util.Arrays;

/**
 * Leetcode 75 https://leetcode.com/problems/move-zeroes
 */
public class MoveZero {
	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		System.out.println(Arrays.toString(nums));
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
		
		int[] nums2 = { 0, 1, 0, 3, 12, 9, 0, 13, 88, 99, 0 };
		System.out.println(Arrays.toString(nums2));
		moveZeroes(nums2);
		System.out.println(Arrays.toString(nums2));

	}

	public static void moveZeroes(int[] nums) {
		int n = nums.length;
		
		int indexAfterZero = 0;
		
		for (int i = 0; i < n; i++) {
			int tmp = nums[i];
			if (tmp != 0) {
				nums[i] = nums[indexAfterZero];
				nums[indexAfterZero] = tmp;
						
				indexAfterZero++;
			}
		}
	}

}
