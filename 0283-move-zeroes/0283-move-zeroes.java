class Solution {
    public void moveZeroes(int[] nums) {
        int low=0;

        int high =0;

        while(high<nums.length)
        {

            if(nums[high]!=0)
            {
                int temp = nums[high];
                nums[high] = nums[low];
                nums[low] = temp;

                low++;
            }

            high++;
        }
    }
}