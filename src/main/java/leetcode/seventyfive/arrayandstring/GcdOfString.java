package leetcode.seventyfive.arrayandstring;

public class GcdOfString {
	public static void main(String[] args) {
		System.out.println(gcdOfString("ABCABCABCABC", "ABCABC")); // ABCABC
		
		System.out.println(gcdOfString("ABABAB", "AB")); // AB
		
		System.out.println(gcdOfString("LEET", "CODE")); // ""
	}

	static String gcdOfString(String str1, String str2) {
		if (!str1.concat(str2).equals(str2.concat(str1))) {
			//return "BLANK";
			return ""; // no gdc
		}

		int resultLength = gdc(str1.length(), str2.length());
		return str1.substring(0, resultLength);

	}

	static int gdc(int a, int b) {
		while (b > 0) {
			int tmp = b;
			b = a % b; // swap b = remainer
			a = tmp; // swap a = original b
		}
		return a;
	}
}
