class Solution {
    int dp[][];

    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount+1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(coins, 0, amount, n);
    }

    int solve(int[] coins, int i, int amount, int n) {

        if (amount == 0) {
            return 1;
        }

        if (i == n) {
            return 0;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        if (coins[i] > amount) {
             return dp[i][amount] = solve(coins, i + 1, amount, n);
        }

        int take = solve(coins, i, amount - coins[i], n);

        int skip = solve(coins, i + 1, amount, n);

        return dp[i][amount] = take + skip;
    }
}