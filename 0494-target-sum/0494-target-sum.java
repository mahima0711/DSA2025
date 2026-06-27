class Solution {

    int dp[][];

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        dp = new int[n][2001];

        int sum = 0;

        for (int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, target, n, 0, sum);
    }

    int solve(int[] nums, int target, int n, int i, int sum) {
        if (i == n) {
            return sum == target ? 1 : 0;
        }

        if (dp[i][sum + 1000] != -1) {
            return dp[i][sum + 1000];
        }
        int plus = solve(nums, target, n, i + 1, sum + nums[i]);

        int minus = solve(nums, target, n, i + 1, sum - nums[i]);

        return dp[i][sum + 1000] = plus + minus;
    }
}