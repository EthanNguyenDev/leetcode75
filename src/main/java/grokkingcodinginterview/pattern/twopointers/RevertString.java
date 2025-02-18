package grokkingcodinginterview.pattern.twopointers;

public class RevertString {

	public static void main(String[] args) {
		String s = "Hello     World";
		// this only work with proper words with 1 single space, so removing excessive spaces
		char[] characters = s.trim().replaceAll("\\s+", " ").toCharArray();
//		char[] characters = s.trim().toCharArray();
		
		// this actually can work with words separated by multi-spaces
		reverse(characters, 0, characters.length - 1);
		reverseWordsInPlace(characters);
		System.out.println(new String(characters));
		
		// testcase 2
		String s2 = "To be or not to be";
		char[] characters2 = s2.trim().replaceAll("\\s+", " ").toCharArray();
		reverse(characters2, 0, characters2.length - 1);
		reverseWordsInPlace(characters2);
		System.out.println(new String(characters2));
	}

	private static void reverseWordsInPlace(char[] characters) {
		int start = 0;
		int end = 0;

		while (start < characters.length) {
			// find the 1st char of the word
			while (start < characters.length && characters[start] == ' ') {
				start++;
			}
			// after this, both are at the start of the word
			end = start;

			while (end < characters.length && characters[end] != ' ') {
				end++;
			}
			// now end is at the space before the new word

			reverse(characters, start, end - 1);

			// now let start from the space
			start = end;
		}
	}

	static void reverse(char[] characters, int start, int end) {
		while (start < end) {
			char tmp = characters[start];
			characters[start] = characters[end];
			characters[end] = tmp;
			start++;
			end--;
		}
	}
}
