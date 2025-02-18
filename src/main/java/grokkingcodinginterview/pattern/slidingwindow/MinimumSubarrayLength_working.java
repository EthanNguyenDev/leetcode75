package grokkingcodinginterview.pattern.slidingwindow;

public class MinimumSubarrayLength_working {

	public static void main(String[] args) {
//		int[] nums = { 2, 3, 1, 2, 4, 3 };
//		int target = 7;
		int[] nums = { 7, 2, 4, 6, 5, 8 };
		int target = 6;

		System.out.println("Minimum length of subarray: " + minSubArrayLen(target, nums)); // Output: 2
	}

	public static int minSubArrayLen(int target, int[] nums) {
		int minLength = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;

		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];

			while (sum >= target) {
				minLength = Math.min(minLength, right - left + 1);
				sum -= nums[left];
				left++;
			}
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}

}
