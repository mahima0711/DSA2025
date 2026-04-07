class Solution {

    public int rob(int[] nums) {
        int n = nums.length;

        // Edge case
        if (n == 1) return nums[0];

        // Case 1: rob from 0 → n-2
        int case1 = robRange(nums, 0, n - 2);

        // Case 2: rob from 1 → n-1
        int case2 = robRange(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    // Bottom-up DP using array
    private int robRange(int[] nums, int start, int end) {

        int len = end - start + 1;

        int p1 = 0; // no house
        int p2 = nums[start]; // first house in this range

        for (int i = 2; i <= len; i++) {

            int skip = p2;
            int steal = nums[start + i - 1] + p1;

            p1 = p2;
            p2 = Math.max(skip, steal);
        }

        return p2;
    }
}