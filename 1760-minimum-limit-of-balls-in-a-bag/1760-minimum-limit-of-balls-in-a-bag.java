class Solution {

    boolean canSplit(int nums[], int maxOperations, int mid)
    {
        int operations = 0;

        for(int num : nums)
        {
            operations += (num - 1) / mid;
        }

        return operations <= maxOperations;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        
        int left = 1;
        int right = Integer.MIN_VALUE;

        for(int num : nums)
        {
            right = Math.max(right, num);
        }

        while(left < right)
        {
            int mid = left + (right - left)/2;

            if(canSplit(nums, maxOperations, mid))
            {
                right = mid;
            }
            else
            {
                left = mid+1;
            }
        }

        return left;
    }
}