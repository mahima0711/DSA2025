class Solution {
    public void sortColors(int[] nums) {
        int i=0;

        int j=0;
        int k=nums.length-1;

        while(j<=k)
        {
            if(nums[j] == 0)
            {
                int temp = nums[j];
                nums[j] =nums[i];
                nums[i] = temp;
                j++;
                i++;
            }
            else if(nums[j] == 2)
            {
                int temp = nums[j];
                nums[j] =nums[k];
                nums[k] = temp;
                k--;
            }
            else if(nums[j] ==1)
            {
                j++;
            }
        }
    }
}