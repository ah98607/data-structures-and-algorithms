class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int net = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            net += gas[i] - cost[i];
            if (net < 0) {
                net = 0;
                start = i + 1;
            }
        }
        if (totalGas >= totalCost) {
            return start;
        }
        return -1;
    }
}