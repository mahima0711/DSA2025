class Solution {

    int dp[][];
    public boolean canPartition(int[] nums) {

        int n = nums.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        dp = new int[201][target+1];

        for(int i=0;i<201;i++)
        {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, target, 0, 0);

    }

    boolean solve(int[] nums, int target, int i, int s) {

        if (i == nums.length) {
            return s == target;
        }

        if(dp[i][s] != -1)
        {
             return dp[i][s] == 1;
        }
        boolean take = false;

        if (s + nums[i] <= target) {
            take = solve(nums, target, i + 1, s + nums[i]);
        }

        boolean skip = solve(nums, target, i + 1, s);

        dp[i][s] = (skip || take) ? 1 : 0;

        return skip || take;
    }
}