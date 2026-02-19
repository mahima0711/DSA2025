class Solution {
    
    int subsets = 0;
    public int beautifulSubsets(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

         backTrack(0, nums, k, map);

         return subsets-1;
    }

    void backTrack(int index, int[] nums, int k, Map<Integer, Integer> map) {

        if (index == nums.length) {
            subsets++;
            return;
        }

        //not take case
        backTrack(index + 1, nums, k, map);

        if (!map.containsKey(nums[index] + k) && !map.containsKey(nums[index] - k)) {
            map.put(nums[index], map.getOrDefault(nums[index], 0) + 1);
            backTrack(index + 1, nums, k, map);
            map.put(nums[index], map.get(nums[index])-1);
             if (map.get(nums[index]) == 0) {
                map.remove(nums[index]);
            }
        }
    }
}