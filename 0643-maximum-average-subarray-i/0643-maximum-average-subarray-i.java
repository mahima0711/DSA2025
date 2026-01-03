class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int sum =0;

        for(int i=0;i<k;i++)
        {
            sum = sum + nums[i];
        }

        double max = (double)sum/k;

        int i = k;
        while(i<nums.length)
        {
            sum = sum + nums[i] - nums[i-k];
            max = Math.max(max, (double) sum/k);
            i++;
        }

        return max;
    }
}