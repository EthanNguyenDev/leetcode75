package algorithm.sort.bublesort;

import java.util.Arrays;

public class Happy {
	public static void main(String[] args) {

		happy(3);

	}

	static void happy(int n) {
		if (n == 0) return;
		happy(n-1);
		System.out.println("I am quite happy today!");
		happy(n-1);
	}
}
