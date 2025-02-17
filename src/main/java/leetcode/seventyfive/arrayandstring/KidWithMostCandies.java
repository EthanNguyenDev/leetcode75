package leetcode.seventyfive.arrayandstring;

public class KidWithMostCandies {

	public static void main(String[] args) {
		int[] flowerbed = { 1, 0, 0, 0, 1 };
		int n = 1;
		System.out.println(canPlaceFlowers(flowerbed, n));

		int[] flowerbed2 = { 1, 0, 0, 0, 1 };
		int n2 = 2;
		System.out.println(canPlaceFlowers(flowerbed2, n2));

		int[] flowerbed3 = { 1, 0, 0, 0, 0, 1 };
		int n3 = 2;
		System.out.println(canPlaceFlowers(flowerbed3, n3));

		int[] flowerbed4 = { 0, 0, 1, 0, 1 };
		int n4 = 1;
		System.out.println(canPlaceFlowers(flowerbed4, n4));

		int[] flowerbed5 = { 1, 0, 0, 0, 1, 0, 0 };
		int n5 = 2;
		System.out.println(canPlaceFlowers(flowerbed5, n5));

		int[] flowerbed6 = { 0, 1, 0 };
		int n6 = 1;
		System.out.println(canPlaceFlowers(flowerbed6, n6));

	}

	static public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		int i = 0;
		int length = flowerbed.length;

		if (length == 1 && flowerbed[0] == 0) {
			return true;
		}

		while (i < length) {
			if (flowerbed[i] == 0) {
				if (i == 0) {
					if (flowerbed[i + 1] == 0) {
						count++;
						flowerbed[i] = 1;
					}
				} else if (i == length - 1) {
					if (flowerbed[i - 1] == 0) {
						count++;
						flowerbed[i] = 1;
					}
				} else if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
					// requires 3 consecutive 0 to plant a flower
					count++;
					flowerbed[i] = 1; // plant the flower & continue
				}
			}
			i++;
		}

		return count >= n;
	}
}
