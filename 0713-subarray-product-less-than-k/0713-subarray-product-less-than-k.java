class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int low =0;
        int count=0;
        int product=1;

        for(int high =0; high <nums.length;high++)
        {
         product =product * nums[high];

         while(product >=k && low <=high)
         {
            product /=nums[low];
            low++;
         }

         count= count+ (high-low +1);
        }

        return count;
    }
}