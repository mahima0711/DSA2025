class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int prefix = 0;
        int count=0;
        map.put(0,1);

        for(int i=0;i<nums.length;i++)
        {
            prefix = prefix+nums[i];
    
            if(map.containsKey(prefix-k))
            {
                count += map.get(prefix - k);
            }
            map.put(prefix, map.getOrDefault(prefix,0)+1);
        }

        return count;
    }
}