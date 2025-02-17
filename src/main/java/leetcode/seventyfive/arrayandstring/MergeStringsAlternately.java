package leetcode.seventyfive.arrayandstring;

public class MergeStringsAlternately {
	public static void main(String[] args) {
		String p = "abc";
		String q = "pqr";
		System.out.println(mergeAlternately(p, q));
		
		String p2 = "ab";
		String q2 = "pqrs";
		System.out.println(mergeAlternately(p2, q2));
		
		String p3 = "abcd";
		String q3 = "pq";
		System.out.println(mergeAlternately(p3, q3));
	}

	static public String mergeAlternately(String word1, String word2) {
		StringBuilder result = new StringBuilder();

		int index = 0;

		while (index < word1.length() && index < word2.length()) {
			result.append(word1.charAt(index));
			result.append(word2.charAt(index));
			index++;
		}

		if (index < word1.length()) {
			while (index < word1.length()) {
				result.append(word1.charAt(index));
				index++;
			}
		}

		if (index < word2.length()) {
			while (index < word2.length()) {
				result.append(word2.charAt(index));
				index++;
			}
		}

		return result.toString();
	}
}
