class Solution {

    int dp[];
    public int rob(int[] nums) {
        
        int n = nums.length;

         dp = new int[n];

        for(int i=0;i<n;i++)
        {
            dp[i] = -1;
        }

        int i=0;

        return solve(nums, i, n);
    }

    int solve(int nums[], int i, int n)
    {
        if(i>=n)
        {
            return 0;
        }

        if(dp[i]!=-1)
        {
            return dp[i];
        }

        int steal = nums[i] + solve(nums, i+2, n);

        int skip = solve(nums, i+1, n);

        return dp[i] = Math.max(steal, skip);
    }
}