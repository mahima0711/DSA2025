class Solution {
    public int maxAbsoluteSum(int[] nums) {
      int maxEnding = 0, minEnding = 0; 
        int maxSum = 0, minSum = 0;

        for (int num : nums) {
            
            // Kadane for max subarray sum
            maxEnding = Math.max(num, maxEnding + num);
            maxSum = Math.max(maxSum, maxEnding);
            
            // Kadane for min subarray sum
            minEnding = Math.min(num, minEnding + num);
            minSum = Math.min(minSum, minEnding);
        }

        // absolute best
        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
}