package algorithm.sort.mergesort;

import java.util.Arrays;

public class FBSConverter {

	public static void main(String[] args) {
//		int[] myArray = { 7, 20, 10, 19, 10, 17, 14, 15, 15 };
		int[] myArray = { 15, 20, 10, 19, 10, 17, 14, 15, 7 };
		convertToFBSArray(myArray);
		System.out.print("FBS array: ");
		for (int value : myArray) {
			System.out.print(value + " ");
		}
	}

    public static int[] convertToFBSArray(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] fbsArray = new int[n];
        int evenIndex = 0;
        int oddIndex = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                fbsArray[evenIndex] = arr[i];
                evenIndex++;
            } else {
                fbsArray[oddIndex] = arr[i];
                oddIndex--;
            }
        }
        return fbsArray;
    }

}
