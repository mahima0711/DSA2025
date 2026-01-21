class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        
        int ans[] = new int[nums.size()];
        for(int i=0; i< nums.size();i++)
        {
            int val = nums.get(i);
            if(val % 2 == 0)
            {
                ans[i] = -1;
            }
            else
            {
                long t = (long) val + 1;
                
                long lowbit = t & -t;
                
                ans[i] = val - (int)(lowbit >> 1);
            }


        }

        return ans;
    }
}