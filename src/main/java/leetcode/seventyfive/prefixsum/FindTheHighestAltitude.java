package leetcode.seventyfive.prefixsum;

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain));

        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println(largestAltitude(gain2));
    }

    // use prefix sum to infer each altitude then check max altitude
    public static int largestAltitude(int[] gain) {
        int[] altitude = new int[gain.length + 1];
        altitude[0] = 0;
        int maxAltitude = 0;

        int currentAltitude = 0;
        for (int i = 0; i < gain.length; i++) {
            altitude[i + 1] = altitude[i] + gain[i];
            if (altitude[i + 1] > maxAltitude) {
                maxAltitude = altitude[i + 1];
            }
        }

        return maxAltitude;
    }
}
