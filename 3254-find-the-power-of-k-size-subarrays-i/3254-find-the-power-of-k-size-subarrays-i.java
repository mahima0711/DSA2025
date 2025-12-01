class Solution {
    public int[] resultsArray(int[] nums, int k) {

        int window = 0;
        int needed = k - 1;
        int n = nums.length;
        int m = n - k + 1;
        int res[] = new int[m];
        for (int i = 0; i < needed; i++) {
            if (nums[i + 1] - nums[i] == 1) {
                window++;
            }
        }

        if (window == needed) {
            res[0] = nums[k - 1];
        } else {
            res[0] = -1;
        }

        for (int start = 1; start < m; start++) {
            if (nums[start] - nums[start - 1] == 1) {
                window--;
            }

            int left = start + k - 2;
            int right = start + k - 1;

            if (nums[right] - nums[left] == 1) {
                window++;
            }

            if (window == needed) {
                res[start] = nums[start+k-1];
            } else
                res[start] = -1;
        }
        return res;
    }
}