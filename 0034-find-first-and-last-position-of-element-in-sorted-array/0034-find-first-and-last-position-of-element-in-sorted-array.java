class Solution {
    public int[] searchRange(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low < nums.length && nums[low] == target) {
            ans[0] = low;
        } else {
            return ans; // target not present at all
        }

         low = 0;
        high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        ans[1] = high;

        return ans;
    }
}