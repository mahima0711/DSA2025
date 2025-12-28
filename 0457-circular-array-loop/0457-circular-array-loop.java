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

    for(int i=0; i< nums.length;i++)
    {
        int slow = i;
        int fast = i;

        boolean isPos = nums[slow] > 0;

        while (true) {
            slow = calculateNextIdx(nums, slow);

            if (isPos) {
                if (nums[slow] < 0)
                    break;
            }
            else
            {
                 if (nums[fast] > 0)
                    break;
            }

            fast = calculateNextIdx(nums, fast);

            if (isPos) {
                if (nums[fast] < 0)
                    break;
            }
            else
            {
                 if (nums[fast] > 0)
                    break;
            }

            fast = calculateNextIdx(nums, fast);

            if (isPos) {
                if (nums[fast] < 0)
                    break;
            }
            else
            {
                 if (nums[fast] > 0)
                    break;
            }

            if (slow == fast) {
                if (slow == calculateNextIdx(nums, slow))
                    break;

                return true;
            }
 
        }
    }

        return false;

    }
}