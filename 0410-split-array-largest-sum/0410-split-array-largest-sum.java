class Solution {

    public boolean canSplit(int nums[], int k, int mid) {

        int curr = 1;
        int splitArr =0;

        for(int i=0;i<nums.length;i++)
        {
            if(splitArr + nums[i] <= mid)
            {
                splitArr += nums[i];
            }
            else
            {
                curr++;
                splitArr = nums[i];
                if(curr > k)
                {
                    return false;
                }
            }
        }

        return curr <= k;

    }

    public int splitArray(int[] nums, int k) {
        if (k > nums.length)
            return -1;

        int left = Integer.MIN_VALUE;
        int right = 0;

        for (int i = 0; i < nums.length; i++) {
            right +=  nums[i];
            left = Math.max(left, nums[i]);
        }

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (canSplit(nums, k, mid)) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}