package leetcode.seventyfive.graph.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class ReorderRouteToLeadToCityZero {

	public static void main(String[] args) {
		int[][] connections = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
		System.out.println("minimum number of edges changed to reach city0 is: " + bfs(6, connections)); // 3

		int[][] connections2 = { { 1, 0 }, { 1, 2 }, { 3, 2 }, { 3, 4 } };
		System.out.println("minimum number of edges changed to reach city0 is: " + bfs(5, connections2)); // 2

		int[][] connections3 = { { 1, 0 }, { 2, 0 } };
		System.out.println("minimum number of edges changed to reach city0 is: " + bfs(3, connections3)); // 0

	}

	static int bfs(int n, int[][] connections) {
//		// convert to adj matrix
//		int[][] graph = new int[n][n];
//		for (int[] connection: connections) {
//			int city1 = connection[0];
//			int city2 = connection[1];
//			graph[city1][city2] = 1; // directed graph
//		}
//
//		boolean[] visited = new boolean[n];
//		int noOfChange = 0;
//
//		Queue<Integer> q = new LinkedList<>();
//		q.offer(0); // start with city0
//		visited[0] = true; // start with city0
//        
//		while (!q.isEmpty()) {
//			int currentCity = q.poll();
//			for (int neighbor = 0; neighbor < graph.length; neighbor++) {
//				if (!visited[neighbor]) {
//					if (graph[currentCity][neighbor] == 1) {
//						visited[neighbor] = true;
//						q.offer(neighbor);
//						noOfChange++;
//					}
//					if (graph[neighbor][currentCity] == 1) {
//						visited[neighbor] = true;
//						q.offer(neighbor);
//					}
//				}
//			}
//		}
//
//		return noOfChange;

		// Count the number of reverse edges for each city
		int[] reverseEdgesCount = new int[n];
		for (int[] connection : connections) {
			int city2 = connection[1];
			reverseEdgesCount[city2]++;
		}

		boolean[] visited = new boolean[n];
		int noOfChange = 0;

		Queue<Integer> q = new LinkedList<>();
		q.offer(0); // Start with city 0
		visited[0] = true; // Mark city 0 as visited

		while (!q.isEmpty()) {
			int currentCity = q.poll();
			for (int neighbor = 0; neighbor < n; neighbor++) {
				if (!visited[neighbor] && reverseEdgesCount[neighbor] > 0) {
					// If there's a reverse edge, we need to change its direction
					visited[neighbor] = true;
					q.offer(neighbor);
					noOfChange++;
				}
			}
		}

		return noOfChange;
	}

}
