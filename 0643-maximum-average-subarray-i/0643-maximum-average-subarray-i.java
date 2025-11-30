class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long sum=0L;

        for(int i=0;i<k;i++)
        {
            sum =sum +nums[i];
        }

        long maxSum =sum;

        for(int i=k;i<nums.length;i++)
        {
            sum =sum+nums[i];
            sum=sum-nums[i-k];

            if(maxSum<sum)
            {
                maxSum=sum;
            }
        }

        return (double)maxSum/(double)k;
    }
}