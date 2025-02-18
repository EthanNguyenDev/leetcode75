package grokkingcodinginterview.pattern.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MaximumInWindow_working {
	public static void main(String[] args) {
		int[] nums = { -4, 5, 4, -4, 4, 6, 7, 20 };
		int k = 2;
				
		int n = nums.length;
		int[] result = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        
        // first k element
        for (int i = 0; i < k; i++) {
        	while (!q.isEmpty() && nums[i] > nums[q.peekLast()] ) {
        		q.pollLast();
        	}
			q.offer(i);
		}
        
        System.out.println(q);
        
        // the remaning
	}
	
	
}
