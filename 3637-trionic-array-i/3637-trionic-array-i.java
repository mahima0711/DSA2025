class Solution {
    public boolean isTrionic(int[] nums) {
        
  int length = nums.length;
        if(length < 4)
        {
            return false;
        }

        int i=1;

        // First increasing phase
        while(i<length && nums[i]>nums[i-1])
        {
            i++;
        }
        if(i==length || i==1)
        {
            return false;
        }

        // Decreasing phase
        while(i<length && nums[i]<nums[i-1])
        {
            i++;
        }
        if(i==length)
        {
            return false;
        }

        // Final increasing phase
        while(i<length && nums[i]>nums[i-1])
        {
            i++;
        }
        
        //Return true only if it has reached the end in the increasing order
        if(i==length)
        {
            return true;
        }
    return false;
    }
}