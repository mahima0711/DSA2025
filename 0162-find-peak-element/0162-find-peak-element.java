class Solution {
    public int findPeakElement(int[] nums) {
        
        int low =0;
        int high = nums.length -1;

        while(low < high)
        {
            int mid = low + (high-low) / 2;

            // if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
            // {
            //     return mid;
            // }

            if(nums[mid+1] > nums[mid])
            {
                low = mid+1;
            }
            else
            {
               high = mid;
            }
        }

        return low;
    }
}