class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;

        int sumGas = 0;
        int sumCost = 0;

        for (int i = 0; i < n; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }

        if (sumGas < sumCost) {
            return -1;
        }

        int sum = 0;

        int idx = 0;

        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];

            if (sum < 0) {
                sum = 0;
                idx = i + 1;
            }
        }

        return idx;
    }
}