package leetcode.seventyfive.slidingwindow;

public class MaxConsecutiveOnes {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		int k = 2;
		System.out.println(maxConsecutiveOnes(nums, k)); // 6
		
		int[] nums2 = { 0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1 };
		int k2 = 3;
		System.out.println(maxConsecutiveOnes(nums2, k2)); //10


	}

	public static int maxConsecutiveOnes(int[] nums, int k) {
		int n = nums.length;
		int result = 0;
		int left = 0;
		int countZeros = 0;

		for (int right = 0; right < n; right++) {
			if (nums[right] == 0) {
				countZeros++;
			}
			
			// reduce window
			while (countZeros > k) {
				if (nums[left] == 0) {
					countZeros--;
				}

				left++;
			}

			if (result < (right - left + 1)) {
				result = right - left + 1;
			}
		}

		return result;
	}
}
