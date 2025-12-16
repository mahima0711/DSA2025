class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int res[] = new int[nums1.length];
        stack.push(nums2[nums2.length - 1]);
        map.put(nums2[nums2.length-1], -1);

        for (int i = nums2.length-2; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            if (stack.empty()) {
                map.put(nums2[i],-1);
            } else {
                map.put(nums2[i],stack.peek());
            }
            stack.push(nums2[i]);
        }
         
         for(int i=0;i< nums1.length;i++)
         {
            if(map.containsKey(nums1[i]))
            {
                res[i] = map.get(nums1[i]);
            }
         }

       
        return res;

    }
}