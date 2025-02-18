package grokkingcodinginterview.pattern.twopointers;

public class CheckPalindromeHard {
	public static void main(String[] args) {
		String s = "RACEACAR"; // true
		System.out.println(isAlmostPalindrome(s));
		
		String s2 = "abcdeca"; // false
		System.out.println(isAlmostPalindrome(s2));
		
		String s3 = "H"; // true
		System.out.println(isAlmostPalindrome(s3));
		
		String s4 = "AEBCDDCBA"; // true
		System.out.println(isAlmostPalindrome(s4));
		
		String s5 = "ABCDCBGGA"; // false
		System.out.println(isAlmostPalindrome(s5));

	}

	static boolean isAlmostPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			char startChar = s.charAt(start);
			char endChar = s.charAt(end);
			
			if (startChar != endChar) {
//				 if mismatch occur, skip that element and check the remaining substring
				String temp = s.substring(start + 1, end + 1);
				String temp2 = s.substring(start, end);
				return isPalindrome(temp) || isPalindrome(temp2);
			}
			start++;
			end--;
		}
		return true;
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
