package grokkingcodinginterview.pattern.fastslowpointers;

public class HappyNumber {

	public static void main(String[] args) {
		System.out.println("Is happy number");
		int n = 4;
		System.out.println(n + " is happy? " + isHappyNumber(n)); // false

		int n2 = 28;
		System.out.println(n2 + " is happy? " + isHappyNumber(n2)); // true
	}

	static boolean isHappyNumber(int n) {
		int slow = n;
		int fast = n;

		// init fast = sum of square of all digits
//		int fast = 0;
//		int[] digits = splitIntoDigits(n);
//		for (int i = 0; i < digits.length; i++) {
//			fast += digits[i] * digits[i];
//		}
		
		// the trick is to do first before checking
		do {
			slow = sumSquareOfNumber(slow);
			fast = sumSquareOfNumber(sumSquareOfNumber(fast));
		} while (fast != slow);

		return slow == 1;

	}

	static int sumSquareOfNumber(int n) {
		int[] digits = splitIntoDigits(n);
		return sumSquareOfDigits(digits);
	}

	static int[] splitIntoDigits(int n) {
		String number = String.valueOf(n);
		int[] result = new int[number.length()];
		for (int i = 0; i < number.length(); i++) {
			char digit = number.charAt(i);
			result[i] = Integer.parseInt(Character.toString(digit));
		}
		return result;
	}

	static int sumSquareOfDigits(int[] digits) {
		int result = 0;
		for (int i = 0; i < digits.length; i++) {
			result += digits[i] * digits[i];
		}
		return result;
	}

}
