class Solution {
    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[nums.length];
        stack.push(nums[nums.length-1]);

        for(int i=nums.length-1 ; i>=0;i--)
        {
            stack.push(nums[i]);
        }

        for (int i = nums.length-1; i >=0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }

                if(stack.empty())
                {
                    ans[i] = -1;
                }
                else
                {
                    ans[i] = stack.peek();
                }

                stack.push(nums[i]);
        }

        // if(!stack.empty())
        // {
        //     ans[nums.length-1] = stack.peek();
        // }
        // else
        //     ans[nums.length-1] = -1;
    
        return ans;
    }
}