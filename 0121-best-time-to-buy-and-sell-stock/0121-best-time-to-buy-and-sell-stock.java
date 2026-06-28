class Solution {

    int dp[][];

    public int maxProfit(int[] prices) {
        int n = prices.length;

        dp = new int[n][2];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return solve(prices, 0, 0);
    }

    int solve(int[] prices, int i, int bought) {

        if (i == prices.length)
            return 0;

        if (dp[i][bought] != -1)
            return dp[i][bought];

        if (bought == 0) {

            int buy = -prices[i] + solve(prices, i + 1, 1);

            int skip = solve(prices, i + 1, 0);

            return dp[i][bought] = Math.max(buy, skip);

        } else {

            int sell = prices[i];

            int hold = solve(prices, i + 1, 1);

            return dp[i][bought] = Math.max(sell, hold);
        }
    }
}