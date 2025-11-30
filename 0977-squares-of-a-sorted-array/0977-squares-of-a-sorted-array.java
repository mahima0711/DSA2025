class Solution {
    public int[] sortedSquares(int[] nums) {
        var increment = 0;
        var decrement = nums.length - 1;
        
        var result = new int[nums.length];
        
        while (increment <= decrement) {
            if (nums[increment] * nums[increment] > nums[decrement] * nums[decrement]) {
                result[decrement-increment] = nums[increment] * nums[increment];
                increment++;
            }  else {
                result[decrement-increment] = nums[decrement] * nums[decrement];
                decrement--;
            }
        }
        return result;
    }
}