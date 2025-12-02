class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      int low=0;
      Set<Integer> window = new HashSet<>();

      for(int high=0;high<nums.length;high++)
      {
        if(window.contains(nums[high]))
        {
            return true;
        }

        window.add(nums[high]);
        if(high-low>=k)
        {
            window.remove(nums[low]);
            low++;
        }
      }

      return false;
    }
}