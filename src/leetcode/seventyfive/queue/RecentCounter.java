package leetcode.seventyfive.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RecentCounter {
	public static void main(String[] args) {
		RecentCounter recentCounter = new RecentCounter();
		System.out.println(recentCounter.ping(1)); // requests = [1], range is [-2999,1], return 1
		System.out.println(recentCounter.ping(100)); // requests = [1, 100], range is [-2900,100], return 2
		System.out.println(recentCounter.ping(3001)); // requests = [1, 100, 3001], range is [1,3001], return 3
		System.out.println(recentCounter.ping(3002)); // requests = [1, 100, 3001, 3002], range is [2,3002], return 3

	}

	private Queue<Integer> queue = new LinkedList<>();

	public RecentCounter() {

	}

	public int ping(int t) {
		queue.add(t);

		int duration = 3000;

		while (!queue.isEmpty() && queue.peek() < t - duration) {
			queue.poll();
		}

		return queue.size();
	}
}
