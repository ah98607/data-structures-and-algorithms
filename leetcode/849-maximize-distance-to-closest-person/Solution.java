class Solution {
    public int maxDistToClosest(int[] seats) {
        int start = 0;
        int maxDist = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (start == 0) {
                    maxDist = i - start;
                }
                else {
                    maxDist = Math.max(maxDist, (i - start + 1) / 2);
                }
                start = i + 1;
            }
        }
        maxDist = Math.max(maxDist, seats.length - start);
        return maxDist;
    }
}