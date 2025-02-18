package grokkingcodinginterview.pattern.topk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	public static void main(String[] args) {
//		int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6 };
//		int k = 10;
		int[] nums = { 1, 3, 5, 14, 18, 14, 5, 5 };
		int k = 2;

		List<Integer> result = topKFrequentElements(nums, k);
		System.out.println(result);

	}

	static List<Integer> topKFrequentElements(int[] a, int k) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			int currentCount = frequencyMap.getOrDefault(a[i], 0);
			frequencyMap.put(a[i], currentCount + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
				Comparator.comparingInt(Map.Entry::getValue));

		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			minHeap.offer(entry);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		while (!minHeap.isEmpty()) {
			Map.Entry<Integer, Integer> entry = minHeap.poll();
			result.add(entry.getKey());
		}
		
		Collections.reverse(result);
		return result;
	}
}
