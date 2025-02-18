package grokkingcodinginterview.pattern.twopointers;

public class SumPairExist {
	public static void main(String[] args) {
		// when ever there's requirement to find 2 elements in an array that satisfy a condition
		
		int[] a = { 10, 20, 35, 50, 75, 80 }; // given sorted array
		int targetSum = 70;
		
		System.out.println(findSumPair(a, targetSum));
		
		
	}
	
	private static boolean findSumPair(int[] a, int sum) {
		int n = a.length;
		int i = 0;
		int j = n - 1;
		
		while (i < j) {
			if (a[i] + a[j] == sum) {
				System.out.println(a[i] + " and " + a[j] + " = " + sum);
				return true;
			}
			
			if (a[i] + a[j] < sum) {
				i++;
			}
			if (a[i] + a[j] > sum) {
				j--;
			}
			
		}
		
		return false;
		
	}
}
