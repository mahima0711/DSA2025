class Solution {

    public int calculateNextIdx(int[] nums, int curr) {
        int next = curr;

        int seq = nums[curr];

        next = (curr + seq) % nums.length;

        if (next < 0)
            next = next + nums.length;

        return next;
    }

    public boolean circularArrayLoop(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int slow = i;
            int fast = i;

            boolean isPos = nums[slow] > 0;

            while (true) {
                // move slow
                slow = calculateNextIdx(nums, slow);
                if ((nums[slow] > 0) != isPos)
                    break;

                // move fast 1 step
                fast = calculateNextIdx(nums, fast);
                if ((nums[fast] > 0) != isPos)
                    break;

                // move fast 2nd step
                fast = calculateNextIdx(nums, fast);
                if ((nums[fast] > 0) != isPos)
                    break;

                // meeting point
                if (slow == fast) {
                    // ensure not 1-element loop
                    if (slow == calculateNextIdx(nums, slow))
                        break;

                    return true;

                }
            }

        }

        return false;
    }
}