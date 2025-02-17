package leetcode.topasked.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s)); // 3
		
		String s2 = "bbbbb";
		System.out.println(lengthOfLongestSubstring(s2)); // 1
		
		String s3 = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s3)); // 3
	}

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int result = 0;
		int left = 0;
		int right = 0;

		Set<Character> set = new HashSet<>();

		while (right < n) {
			char current = s.charAt(right);
			if (!set.contains(current)) {
				set.add(current);
				right++;
				result = Math.max(result, set.size());
			} else {
				set.remove(s.charAt(left));
				left++;
			}
		}

		return result;
	}
}
