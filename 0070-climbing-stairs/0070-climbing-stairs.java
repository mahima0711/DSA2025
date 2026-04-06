class Solution {

    int[] dp = new int[46];

    public int climbStairs(int n) {
            Arrays.fill(dp, -1);
            return calculate(n, dp);
    }

    int calculate(int n, int[] dp)
    {
        if(n < 0) return 0;

        if(n == 0)
        {
            return 1;
        }

        if(dp[n] != -1) return dp[n];

        return dp[n] = calculate(n-1, dp) + calculate(n-2, dp);
    }
}