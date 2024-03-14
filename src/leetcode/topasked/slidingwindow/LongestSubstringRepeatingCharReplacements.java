package leetcode.topasked.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringRepeatingCharReplacements {

	public static void main(String[] args) {
		String s = "AABABBA";
		int k = 1;
		System.out.println(longestSubstringRepeatingChars(s, k)); // 4
	}

	public static int longestSubstringRepeatingChars(String s, int k) {
		Map<Character, Integer> countMap = new HashMap<>();
		int max = 0;
		int mostFrequency = 0;
		int right = 0;
		int left = 0;
		int n = s.length();

		while (right < n) {
			char current = s.charAt(right);
			int currentCount = countMap.getOrDefault(current, 0);
			countMap.put(current, currentCount + 1);
			mostFrequency = Math.max(mostFrequency, currentCount + 1);

			// shrink the window from the start
			while (mostFrequency + k < right - left + 1) {
				char x = s.charAt(left);
				countMap.put(x, countMap.get(x) - 1);
				left++;
			}

			max = Math.max(max, right - left + 1);
			
			right++;
		}

		return max;
	}
}
