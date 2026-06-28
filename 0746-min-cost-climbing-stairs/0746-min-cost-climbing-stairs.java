class Solution {

    int dp[];

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        dp = new int[n];

         Arrays.fill(dp, -1);

        return Math.min(solve(cost, 0), solve(cost, 1));
    }

    int solve(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }
        if (dp[i] != -1)
            return dp[i];

        return dp[i] = cost[i] + Math.min(
                solve(cost, i + 1),
                solve(cost, i + 2));
    }
}