class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int minEnding =nums[0];
        int maxEnding=nums[0];
        int maxSum =nums[0];
        int minSum =nums[0];
        int sum = nums[0];
        int res=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            sum = sum+nums[i];
            maxEnding = Math.max(nums[i], nums[i]+maxEnding);
            maxSum = Math.max(maxSum, maxEnding);

            minEnding = Math.min(nums[i], minEnding + nums[i]);
            minSum = Math.min(minEnding, minSum);

        }
        if (maxSum < 0) {
            return maxSum;  // only non-empty subarray is allowed
        }
        return Math.max(maxSum, sum-minSum);
    }
}