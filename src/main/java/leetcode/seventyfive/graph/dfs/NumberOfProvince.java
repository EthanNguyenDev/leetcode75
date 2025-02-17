package leetcode.seventyfive.graph.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvince {

	public static void main(String[] args) {
		int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println("Number of cities/components is: " + findCircleNum(isConnected));  // 2
		
		int[][] isConnected2 = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		System.out.println("Number of cities/components is: " + findCircleNum(isConnected2));  // 3

	}

	static int findCircleNum(int[][] isConnected) {
		boolean[] visited = new boolean[isConnected.length];
		int numCity = 0;

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				numCity++;
				bfs(isConnected, i, visited);
			}
		}

		return numCity;
	}

	static void bfs(int[][] graph, int startingCity, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(startingCity); // start with startingCity
		visited[startingCity] = true; // start with startingCity

		while (!q.isEmpty()) {
			int currentCity = q.poll();
			for (int neighbor = 0; neighbor < graph.length; neighbor++) {
				if ((graph[currentCity][neighbor] == 1 || graph[neighbor][currentCity] == 1) && !visited[neighbor]) {
					visited[neighbor] = true;
					q.offer(neighbor);
				}
			}
		}
	}
}
