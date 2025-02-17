package leetcode.seventyfive.arrayandstring;

/*
hint: using 2 pointers
*/

public class ReverseVowels {

	public static void main(String[] args) {
		String s1 = "leetcode";
		System.out.println(reverseVowels(s1)); // leotcede

		String s2 = "aA";
		System.out.println(reverseVowels(s2)); // Aa
	}

	public static boolean isVowelChar(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U';
	}

	public static String reverseVowels(String s) {
		char[] results = s.toCharArray();
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			if (isVowelChar(results[left]) && isVowelChar(results[right])) {
				char tmp = results[left];
				results[left] = results[right];
				results[right] = tmp;
				left++;
				right--;
			} else if (!isVowelChar(results[left])) {
				left++;
			} else if (!isVowelChar(results[right])) {
				right--;
			}
		}
		
		return new String(results);
	}

}
