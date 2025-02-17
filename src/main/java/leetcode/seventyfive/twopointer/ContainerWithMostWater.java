package leetcode.seventyfive.twopointer;

// This is like finding the maximum area between two vertical lines in a histogram
public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height)); // 49
		
		int[] height2 = { 1, 1 };
		System.out.println(maxArea(height2)); // 1

	}

	static public int maxArea(int[] height) {
		int max = 0;
		int left = 0;
		int right = height.length - 1;

		while (left != right) {
			int areaHeight = Math.min(height[left], height[right]);
			int areaWidth = right - left;
			int area = areaHeight * areaWidth;
			
			if  (max < area) {
				max = area;
			}
			
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return max;
	}
}
