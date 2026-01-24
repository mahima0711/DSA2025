class Solution {
    public int minPairSum(int[] nums) {
        
        Arrays.sort(nums);

        int i=0;
        int j=nums.length-1;
        int max =0;

        while(i < j)
        {
            int ans = nums[i] + nums[j];
            max = Math.max(max, ans);

            i++;
            j--;
        }

        return max;
    }
}