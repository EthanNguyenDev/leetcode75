package leetcode.seventyfive.slidingwindow;

public class LongestSubarrayOfOneAfterDeleting {
	public static void main(String[] args) {

		int[] nums1 = { 1,1,0,1 };
		System.out.println(longestSubarrayOfOneAfterDeleteOneZero(nums1)); // 3

		int[] nums2 = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
		System.out.println(longestSubarrayOfOneAfterDeleteOneZero(nums2)); // 5

	}

	public static int longestSubarrayOfOneAfterDeleteOneZero(int[] nums) {
		int n = nums.length;
		int result = 0;
		int left = 0;
		int countZeros = 0;
		
		// similar to MaxConsecutiveOnes problem
		for (int right = 0; right < n; right++) {
			if (nums[right] == 0) {
				countZeros++;
			}

			// reduce window
			while (countZeros > 1) {
				if (nums[left] == 0) {
					countZeros--;
				}

				left++;
			}

			if (result < (right - left)) {
				result = right - left;
			}
		}

		return result;
	}
}
