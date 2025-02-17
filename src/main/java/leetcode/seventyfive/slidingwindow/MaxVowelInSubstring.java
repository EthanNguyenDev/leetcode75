package leetcode.seventyfive.slidingwindow;

public class MaxVowelInSubstring {
	public static void main(String[] args) {
		String s = "abciiidef";
		int k = 3;
		System.out.println(findMaxVowelInSubString(s, k)); // 3
		
		String s2 = "leetcode";
		int k2 = 3;
		System.out.println(findMaxVowelInSubString(s2, k2)); // 2
		
		String s3 = "aeiou";
		int k3 = 2;
		System.out.println(findMaxVowelInSubString(s3, k3)); // 2

	}

	public static int findMaxVowelInSubString(String s, int k) {
		int n = s.length();
		int result = 0;

		// init
		for (int i = 0; i < k; i++) {
			char c = s.charAt(i);
			if (isVowel(c)) {
				result++;
			}
		}

		// sliding
		int temp = result;
		for (int i = 0; i < n - k; i++) {
			char prev = s.charAt(i);
			char next = s.charAt(i + k);
			
			if (isVowel(prev)) {
				temp--;
			}
			if (isVowel(next)) {
				temp++;
			}
			
			if (temp > result) {
				result = temp;
			}
		}
		return result;
	}
	

	public static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U';
	}
}
