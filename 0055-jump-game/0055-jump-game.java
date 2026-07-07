class Solution {

    int dp[];

    public boolean canJump(int[] nums) {

        int n = nums.length;

        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums, n, 0);
    }

    boolean solve(int[] nums, int n, int i) {
        if (i == n - 1) {
            return true;
        }

        if (i >= n) {
            return false;
        }

        if (dp[i] != -1) {
            return dp[i] == 1;
        }

        if (nums[i] == 0) {
            return false;
        }

        for (int j = 1; j <= nums[i]; j++) {
            if (solve(nums, n, i + j)) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;
        return false;
    }
}