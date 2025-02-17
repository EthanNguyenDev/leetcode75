package leetcode.seventyfive.twopointer;

public class IsSubsequence {
	public static void main(String[] args) {
//		String s = "abc";
//		String t = "ahbgdc";
//		System.out.println(isSubsequence(s, t));
		
		String s2 = "b";
		String t2 = "abc";
		System.out.println(isSubsequence(s2, t2));
		
	}
	
	static boolean isSubsequence(String s, String t) {
		if (s.length() == 0) return true;
		
		char[] sub = s.toCharArray();
		char[] sequence = t.toCharArray();
		
		int sPointer = 0;
		
		for (int i = 0; i < sequence.length; i++) {
			char c = sequence[i];

			if (sPointer == sub.length) {
				break;
			}

			if (sub[sPointer] == c) {
				sPointer++;
			}
		}
		
		
		return sPointer == sub.length;
	}
}
