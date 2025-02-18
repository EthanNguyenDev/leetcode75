package grokkingcodinginterview.pattern.twopointers;

public class RevertString2 {

	public static void main(String[] args) {
		char[] input = "Hello     World".toCharArray();
		
		// first reverse the entire string
		reverse(input, 0, input.length - 1);
		
		// then use below func to handle each reversed word
		reverseWordsInPlace(input);
		System.out.println(input);
	}

	private static void reverseWordsInPlace(char[] characters) {
		int n = characters.length;
		int start = 0, end = 0;
		
		while (start < n) {
			// skip spaces
			while (start < n && characters[start] == ' ') {
				start++;
			}
			// both are at the 1st char
			end = start;
			
			// move end till the 1st space
			while (end < n && characters[end] != ' ') {
				end++;
			}
			// now end is at the 1st space, we reverse this words with params (start, end-1)
			reverse(characters, start, end - 1);
			
			// continue by making start = end = space
			start = end;
		}
		
	}

	static void reverse(char[] characters, int start, int end) {
		while (start < end) {
			char temp = characters[start];
			characters[start] = characters[end];
			characters[end] = temp;
			start++;
			end--;
		}
	}
}
