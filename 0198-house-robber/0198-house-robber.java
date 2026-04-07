class Solution {

    int ans = 0;

    public int rob(int[] nums) {

        int n = nums.length;

        int p1 = 0;
        int p2 = nums[0];
 
        for(int i = 2; i<= n; i++)
        {
            int steal = nums[i-1] + p1;
            int skip = p2;

            p1 = p2;
            p2 = Math.max(steal, skip);
        }

        return p2;
    }
}