class Solution {

    int dp[];

    public int jump(int[] nums) {
        int n = nums.length;

        dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(nums, n, 0);
    }

    int solve(int[] nums, int n, int i) {

        if (i >= n - 1) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = Integer.MAX_VALUE;

        if (nums[i] == 0) {
            return Integer.MAX_VALUE;
        }
        for (int j = 1; j <= nums[i]; j++) {
            int jumps = solve(nums, n, i + j);

            if (jumps != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + jumps);
            }
        }

        return dp[i] = ans;
    }
}