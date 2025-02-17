package leetcode.seventyfive.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*  
 * https://leetcode.com/problems/keys-and-rooms/description/?envType=study-plan-v2&envId=leetcode-75
 * Input: rooms = [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
*/

public class KeyAndRoom {

	public static void main(String[] args) {
		List<List<Integer>> rooms = new ArrayList<>();
		rooms.add(Arrays.asList(1, 3));
		rooms.add(Arrays.asList(3, 0, 1));
		rooms.add(Collections.singletonList(2));
		rooms.add(Collections.singletonList(0));
		System.out.println(canVisitAllRooms(rooms)); // false

		List<List<Integer>> rooms2 = new ArrayList<>();
		rooms2.add(Arrays.asList(1));
		rooms2.add(Arrays.asList(2));
		rooms2.add(Collections.singletonList(3));
		rooms2.add(Collections.emptyList());
		System.out.println(canVisitAllRoomsDFS(rooms2)); // true
	}

	static public boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
		int n = rooms.size();
		boolean[] visited = new boolean[n];
		
		Stack<Integer> s = new Stack<>();
		s.push(0);
		visited[0] = true;
		
		while (!s.isEmpty()) {
			int currentRoom = s.pop();
			for (int neighbor: rooms.get(currentRoom)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					s.push(neighbor);
				}
				
			}
		}
		
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		
		return true;
		
	}

	// this is BFS not DFS
	static public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int n = rooms.size();
		boolean[] visited = new boolean[n];

		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		visited[0] = true;

		while (!q.isEmpty()) {
			int currentRoom = q.poll();
			for (int neibough : rooms.get(currentRoom)) {
				if (!visited[neibough]) {
					visited[neibough] = true;
					q.offer(neibough);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				// not connected
				return false;
			}
		}
		return true;
	}
}
