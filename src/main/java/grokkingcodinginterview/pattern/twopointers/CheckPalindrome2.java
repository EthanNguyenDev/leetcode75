package grokkingcodinginterview.pattern.twopointers;

public class CheckPalindrome2 {
	public static void main(String[] args) {
		String s = "racecar";
		String s2 = "ABCDABCD";
		String s3 = "H";
		String s4 = "ABCDDCBA";
		String s5 = "ABCDCBA";

		System.out.println(isPalindrome(s));
		System.out.println(isPalindrome(s2));
		System.out.println(isPalindrome(s3));
		System.out.println(isPalindrome(s4));
		System.out.println(isPalindrome(s5));

	}

	static boolean isPalindrome(String s) {
		int startP = 0;
		int endP = s.length() - 1;

		while (startP < endP) {
			char start = s.charAt(startP);
			char end = s.charAt(endP);
			
			if (start != end) {
				return false;
			}
			startP++;
			endP--;
		}
		return true;
	}

}
