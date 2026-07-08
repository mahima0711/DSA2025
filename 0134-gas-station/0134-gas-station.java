class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        int diff[] = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
        }

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

        int idx = -1;

        for (int i = 0; i < n; i++) {
            sum += diff[i];

            if (sum < 0) {
                sum = 0;
                idx = -1;
            } else if (idx == -1) {
                idx = i;
            }
        }

        return idx;
    }
}