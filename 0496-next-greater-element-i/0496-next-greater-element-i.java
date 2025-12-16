class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[nums2.length];
        int res[] = new int[nums1.length];
        stack.push(nums2[nums2.length - 1]);
        ans[nums2.length-1] = -1;

        for (int i = nums2.length-2; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            if (stack.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(nums2[i]);
        }
        int i = 0;
        while (i < nums1.length) {
            int j = 0;
            while (nums1[i] != nums2[j]) {
                j++;
            }
            res[i] = ans[j];
            i++;
        }
        return res;

    }
}