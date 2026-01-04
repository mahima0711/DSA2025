class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

 long max = 0;
        long sum = 0;

        Set<Integer> set = new HashSet<>();

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // If duplicate appears, shrink window from left
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            // Add current element
            set.add(nums[right]);
            sum += nums[right];

            // If window size exceeds k, shrink from left
            if (right - left + 1 > k) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            // Valid window of size k with all distinct elements
            if (right - left + 1 == k) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}