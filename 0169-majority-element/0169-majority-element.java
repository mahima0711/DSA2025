class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
              int count= map.get(nums[i]);
              if(count>nums.length/2)
                 return nums[i];
            }
        }

        return nums[0];
    }
}