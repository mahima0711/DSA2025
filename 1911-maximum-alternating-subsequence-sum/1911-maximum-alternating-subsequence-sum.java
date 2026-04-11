class Solution {

    long[][] dp;
    public long maxAlternatingSum(int[] nums) {
        
        boolean flag = true;

        dp = new long[nums.length+1][2];

        for(int i=0;i<=nums.length;i++)
        {
            Arrays.fill(dp[i], -1);
        }

         return solve(nums, flag, 0);
    }

    long solve(int[] nums, boolean flag, int idx)
    {

        if(idx>=nums.length)
        {
            return 0;
        }

        int f = flag ? 1 : 0;

        if(dp[idx][f] != -1)
        {
            return dp[idx][f];
        }

        long skip = solve(nums, flag, idx+1);

        int val = nums[idx];

        if(flag == false)
        {
            val = -val;
        }

        long take = solve(nums, !flag, idx+1) + val;

        return dp[idx][f] =  Math.max(skip, take);
    }
}