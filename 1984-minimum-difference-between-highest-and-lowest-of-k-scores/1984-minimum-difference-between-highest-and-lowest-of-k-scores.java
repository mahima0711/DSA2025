class Solution {
    public int minimumDifference(int[] nums, int k) {
        int minAns=Integer.MAX_VALUE;

        if(k <=1)
        {
            return 0;
        }
        Arrays.sort(nums);

        int i=0;
        int j=i+k-1;

        while(i<j && j<nums.length)
        {
            int ans = nums[j] - nums[i];
            minAns = Math.min(minAns, ans);
            i++;
            j++;
        }

        return minAns;
    }
}