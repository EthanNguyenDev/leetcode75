package leetcode.seventyfive.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
	public static void main(String[] args) {
		String senate = "RD";
		System.out.println(predictPartyVictory(senate));
		
		String senate2 = "RDD";
		System.out.println(predictPartyVictory(senate2));
	}

	public static String predictPartyVictory(String senate) {
		Queue<Integer> dire = new LinkedList<>();
		Queue<Integer> radiant = new LinkedList<>();
		int n = senate.length();
		
		char[] senates = senate.toCharArray();
		for (int i = 0; i < senates.length; i++) {
			char c = senates[i];
			if (c == 'R') {
				radiant.add(i);
			} else {
				dire.add(i);
			}
		}
		
		while (!radiant.isEmpty() && !dire.isEmpty()) {
			int radiantIndex = radiant.poll();
			int direIndex = dire.poll();
			
			if (radiantIndex < direIndex) {
				radiant.add(radiantIndex + n);
			} else {
				dire.add(direIndex + n);
			}
		}
		
		return radiant.isEmpty() ? "Dire" : "Radiant";
	}
}
