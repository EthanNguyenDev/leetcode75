package grokkingcodinginterview.pattern.twopointers;

public class CheckPalindrome {
	public static void main(String[] args) {
		String s = "racecar";
		String s2 = "ABCDABCD";
		String s3 = "H";
		String s4 = "ABCDDCBA";

		System.out.println(isPalindrome(s));
		System.out.println(isPalindrome(s2));
		System.out.println(isPalindrome(s3));
		System.out.println(isPalindrome(s4));

	}

	static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		
		while (start < end) {
			char cStart = s.charAt(start);
			char cEnd = s.charAt(end);
			if (cStart != cEnd) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}
