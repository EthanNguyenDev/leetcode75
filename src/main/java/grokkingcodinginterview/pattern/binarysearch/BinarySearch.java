package grokkingcodinginterview.pattern.binarysearch;

public class BinarySearch {
	public static void main(String[] args) {
		int[] nums = { 11, 22, 33, 44, 55, 66, 77 };
		System.out.println(binarySearch(nums, 33)); // 2
//		
		int[] nums2 = { 11, 22, 33, 44, 55, 66, 77 };
		System.out.println(binarySearch(nums2, 88)); // - 1

		int[] nums3 = { -30, -27, -8, -6, -1 };
		System.out.println(binarySearch(nums3, -1)); // 4

		int[] nums4 = { -30, -27, -8, -6, -1 };
		System.out.println(binarySearch(nums4, -30)); // 0
	}

	public static int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
//			int mid = (left + right) / 2;
			int mid = left + (right - left) / 2;
			int midValue = nums[mid];

			if (midValue == target) {
				return mid;
			}

			if (midValue > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return -1;
	}
}
