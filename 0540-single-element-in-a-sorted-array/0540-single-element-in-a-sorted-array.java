class Solution {
    public int singleNonDuplicate(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // handle boundary cases explicitly
            if (mid == 0) {
                //return nums[mid] == nums[mid + 1] ? nums[mid + 2] : nums[mid];
                return nums[mid];
            }

            if (mid == nums.length - 1) {
                return nums[mid] == nums[mid - 1] ? nums[mid - 2] : nums[mid];
            }

            // case: mid is the single element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // case: mid pairs with left
            if (nums[mid] == nums[mid - 1]) {

                // FIX 1: correct modulo precedence
                if ((mid - 1) % 2 == 0) {
                    // pair starts at even index → single is on right
                    low = mid + 1;
                } else {
                    // pair starts at odd index → single is on left
                    high = mid - 2;
                }
            }

            // case: mid pairs with right
            else {

                if (mid % 2 == 0) {
                    // pair starts at even index → single is on right
                    low = mid + 2;
                } else {
                    // pair starts at odd index → single is on left
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
