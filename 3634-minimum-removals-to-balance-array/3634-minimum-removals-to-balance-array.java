class Solution {
    public int minRemoval(int[] nums, int k) {
        
        Arrays.sort(nums);

        int i=0;
        int j=i+1;

        int ans = 0;

        if(j >= nums.length)
           return ans;

        while(j<nums.length)
        {
            long minNum = nums[i];
            long maxNum = nums[j];

            if(maxNum <= (long)minNum*k)
            {
                int maxLen = j-i+1;
                ans = Math.max(maxLen, ans);
                j++;
            }
            else
            {
                i++;
            }
        }

        return nums.length - ans;
    }
}