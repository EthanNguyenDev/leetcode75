package leetcode.seventyfive.stack;

import java.util.Stack;

public class RemoveStarsFromString {
	public static void main(String[] args) {
		String s = "leet**cod*e";
		System.out.println(removeStars(s));
		
	}

	public static String removeStars(String s) {
		char[] chars = s.toCharArray();
		Stack<Integer> indexStack = new Stack<>();
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c != '*') {
				result.append(c);
				indexStack.push(result.length() - 1);
			} else {
				int nonStarIndex = indexStack.pop();
				result.deleteCharAt(nonStarIndex);
			}
		}
		return result.toString();
	}
}
