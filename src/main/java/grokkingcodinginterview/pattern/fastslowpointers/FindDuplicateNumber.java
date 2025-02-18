package grokkingcodinginterview.pattern.fastslowpointers;

//Given an unsorted array of positive numbers, nums, such that the values lie in the range [1, n] inclusive,
//and that there are  n+1 numbers in the array, 
//find and return the duplicate number present in nums. There is only one repeated number in nums.
public class FindDuplicateNumber {
	public static void main(String[] args) {
		int[] nums = { 2, 10, 6, 7, 11, 7, 9, 4, 3, 8, 5, 1 };

		System.out.println(findDuplicate(nums));
	}

	public static int findDuplicate(int[] nums) {
		int fast = nums[0];
		int slow = nums[0];

		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (fast != slow);

		// now fast == slow
		slow = nums[0];
		
		while (fast != slow) {
			slow = nums[slow];
			fast = nums[fast];
		}
		// now fast & slow stop at the duplicated number
		return fast;
	}
}
