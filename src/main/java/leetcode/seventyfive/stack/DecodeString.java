package leetcode.seventyfive.stack;

import java.util.Stack;

public class DecodeString {
	public static void main(String[] args) {
		String s = "3[a]2[bc]";
		System.out.println(decodeString(s));
		
		String s2 = "3[a2[c]]";
		System.out.println(decodeString(s2));

		// trick to convert numeric String to int
		String test = "234";
		int number = 0;
		for (int i = 0; i < test.length(); i++) {
			char c = test.charAt(i);
			number = number * 10 + (c - '0');
		}
		System.out.println(number);
	}

	public static String decodeString(String s) {
		StringBuilder result = new StringBuilder();

		Stack<Integer> counterStack = new Stack<>();
		Stack<String> stringStack = new Stack<>();
		
		char[] ss = s.toCharArray();
		
		int prevDigit = 0;
		for (int i = 0; i < ss.length; i++) {
			char c = ss[i];
			if (c == '[') {
				counterStack.push(prevDigit);
				stringStack.push(result.toString());

				// reset
				result = new StringBuilder();
				prevDigit = 0;
			} else if (c == ']' && !counterStack.isEmpty()) {
				int repeatedTime = counterStack.pop();
				String prev = stringStack.pop();
				
				StringBuilder tmp = new StringBuilder(prev);
				for (int j = 0; j < repeatedTime; j++) {
					tmp.append(result);
				}
				
				result = tmp;
			} else if (Character.isAlphabetic(c)) {
				result.append(c);
			} else if (Character.isDigit(c)) {
				prevDigit = prevDigit * 10  + (c - '0');
			}

		}

		return result.toString();
	}

}
