package leetcode.seventyfive.arrayandstring;

import java.util.ArrayList;
import java.util.List;

public class CanPlaceFlowers {

	public static void main(String[] args) {
		int[] candies = {2,3,5,1,3};
		int extraCandies = 3;
		System.out.println(kidsWithCandies(candies, extraCandies));
		
		int[] candies2 = {4,2,1,1,2};
		int extraCandies2 = 1;
		System.out.println(kidsWithCandies(candies2, extraCandies2));

	}

	static public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> result = new ArrayList<>();
		
		// find the kid with max candy
		int maxCandy = 0;
		for (int i = 0; i < candies.length; i++) {
			int noOfCandy = candies[i];
			if (maxCandy < noOfCandy) {
				maxCandy = noOfCandy;
			}
		}
		
		for (int i = 0; i < candies.length; i++) {
			int noOfCandy = candies[i];
			if (noOfCandy + extraCandies >= maxCandy) {
				result.add(i, true);
			} else {
				result.add(i, false);
			}
		}
		
		return result;
	}
}
