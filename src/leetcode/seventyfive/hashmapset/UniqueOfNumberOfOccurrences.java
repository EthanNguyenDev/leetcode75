package leetcode.seventyfive.hashmapset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOfNumberOfOccurrences {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(nums));
    }


    // use a hashMap to count occurrences + a hashSet to check duplicate occurrence
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int n : arr) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        Set<Integer> checker = new HashSet<>();

        for (int occurence: counter.values()) {
            if (checker.contains(occurence)) {
                return false;
            }
            checker.add(occurence);
        }

        return true;
    }
}
