class Solution {

    int ans = 0;
    int dp[] = new int[101];

    public int rob(int[] nums) {

        int n = nums.length;

        Arrays.fill(dp, -1);

        return solve(nums, 0, n);
    }

    int solve(int[] nums, int i, int n)
    {
        if(i >= n ) return 0;

        if(dp[i] != -1)
        {
            return dp[i];
        }

        int steal = nums[i] + solve(nums, i+2, n);

        int skip = solve(nums, i+1, n);

        return dp[i] = Math.max(steal, skip);
    }

}