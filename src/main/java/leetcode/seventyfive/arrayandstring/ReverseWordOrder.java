package leetcode.seventyfive.arrayandstring;

/*
hint: using 2 pointers
*/

public class ReverseWordOrder {

	public static void main(String[] args) {
		String s1 = "the sky is blue";
		System.out.println(reverseWords(s1)); // "blue is sky the"

		String s2 = "  hello world  ";
		System.out.println(reverseWords(s2)); // "world hello"
		
		String s3 = "a good   example";
		System.out.println(reverseWords(s3)); // "example good a"
	}

	public static String reverseWords(String s) {
		s = s.trim();
		char[] characters = s.toCharArray();
		StringBuilder result = new StringBuilder();
		int slow = characters.length - 1;
		int fast = characters.length - 1;

		while (slow >= 0) {
			// move until fast pointer is a space
			while (fast >= 0 && characters[fast] != ' ') {
				fast--;
			}

			// now fast pointer is at a space, taking substring from index fast -> slow, slow exclusive
			String word = s.substring(fast + 1, slow + 1);
			result.append(word).append(" ");

			// now restart with slow = fast for the next word, skip consecutive spaces if there are
			while (fast >= 0 && characters[fast] == ' ') {
				fast--;
			}
			slow = fast;
		}
		// remove the last space
		return result.toString().trim();
	}

}
