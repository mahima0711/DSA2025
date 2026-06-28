class Solution {

    int dp[][];
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        dp = new int[13][10001];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i], -1);
        }

       
        int ans = solve(coins, 0, amount, n);

        return ans >= 1000000000 ? -1 : ans;
    }

    int solve(int[] coins, int i, int amount, int n)
    {

        if(amount == 0)
        {
            return 0;
        }

        if(i == n)
        {
            return 1000000000;
        }

        if(dp[i][amount] != -1)
        {
            return dp[i][amount];
        }

        if(coins[i] > amount)
        {
            return solve(coins, i+1 , amount, n);
        }

        int take = 1 + solve(coins, i, amount - coins[i], n);

        int skip = solve(coins, i + 1, amount, n);

        return dp[i][amount] =  Math.min(take, skip);
    }
}