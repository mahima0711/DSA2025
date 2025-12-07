class Solution {
    public int longestSubarray(int[] nums) {
        int low=0;
        int arr[] = new int[2];
        int maxLength =0;

        for(int high =0; high< nums.length ; high++)
        {
            arr[nums[high]]++;

            while(arr[0]>=2)
            {
                arr[nums[low]]--;
                low++;
            }

            maxLength = Math.max(maxLength, arr[1]);
        }
        if(arr[1] == nums.length)
        {
          maxLength = arr[1]-1;
        }
        return maxLength;
    }
}