package leetcode.seventyfive.prefixsum;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums)); // expected pivot index 3

        int[] nums2 = {1, 2, 3};
        System.out.println(pivotIndex(nums2)); // expected pivot index -1

        int[] nums3 = {2, 1, -1};
        System.out.println(pivotIndex(nums3)); // expected pivot index 0
    }

    // for each index, find prefixSum at left & right then compare them
    public static int pivotIndex(int[] nums) {
        int n = nums.length;

        int[] prefixSums = prefixSum(nums);

        for (int i = 0; i < n; i++) {
            // check if i is the pivot index
            int leftSum = querySum(prefixSums, 0, i);
            int rightSum = querySum(prefixSums, i, n - 1);
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public static int querySum(int[] prefixSum, int start, int end){
        if (start == 0) {
            return prefixSum[end];
        }
        return prefixSum[end] - prefixSum[start - 1];
    }

    public static int[] prefixSum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        return prefixSum;
    }
}
