class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;

        int result[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] > 0)
            {
                int steps = nums[i] % n;
                int move = (i + steps) % n;
                result[i] = nums[move];
            }else
            {
                int steps = Math.abs(nums[i]) %n;
                int move = (i - steps + n)%n;
                result[i] = nums[move];
            }
        }

        return result;
    }
}