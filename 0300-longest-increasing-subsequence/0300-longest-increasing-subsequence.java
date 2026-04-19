class Solution {

    int[][] dp;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[2501][2501];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return find(nums, 0, -1);
    }

    int find(int[] nums, int i, int p) {
        if (i >= nums.length) {
            return 0;
        }

        if (p != -1 && dp[i][p] != -1) {
            return dp[i][p];
        }

        int take = 0;

        if (p == -1 || nums[i] > nums[p]) {
            take = 1 + find(nums, i + 1, i);
        }

        int skip = find(nums, i + 1, p);

        if (p != -1) {
            dp[i][p] = Math.max(take, skip);
        }

        return Math.max(take, skip);
    }
}