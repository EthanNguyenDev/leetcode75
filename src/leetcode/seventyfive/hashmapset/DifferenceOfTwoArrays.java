package leetcode.seventyfive.hashmapset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferenceOfTwoArrays {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3 };
		int[] nums2 = { 2, 4, 6 };
		System.out.println(differenceOfTwoArrays(nums1, nums2));

		int[] nums12 = { 1, 2, 3, 3 };
		int[] nums22 = { 1, 1, 2, 2 };
		System.out.println(differenceOfTwoArrays(nums12, nums22));

		int[] nums13 = { 26, 48, -78, -25, 42, -8, 94, -68, 26 };
		int[] nums23 = { 61, -17 };
		System.out.println(differenceOfTwoArrays(nums13, nums23));

		int[] nums14 = { -73 };
		int[] nums24 = { -66, 9, -54, -32, 94, 11 };
		System.out.println(differenceOfTwoArrays(nums14, nums24));
	}

	// using 2 set, then use .removeAll to remove intersection between 2 set.
	static List<List<Integer>> differenceOfTwoArrays(int[] nums1, int[] nums2) {
		// use set instead
		List<List<Integer>> result = new ArrayList<>();

		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		for (int num : nums1) {
			set1.add(num);
		}

		for (int num : nums2) {
			set2.add(num);
		}

		List<Integer> inFirst = new ArrayList<>(set1);
		List<Integer> inSecond = new ArrayList<>(set2);
		
		inFirst.removeAll(set2);
		inSecond.removeAll(set1);
		
		result.add(inFirst);
		result.add(inSecond);
		return result;

	}
}
