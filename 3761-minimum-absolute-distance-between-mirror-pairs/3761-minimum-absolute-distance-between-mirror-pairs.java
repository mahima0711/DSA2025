class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            // Look up nums[j] — earlier entries stored reverse(nums[i]) as key
            if (indexMap.containsKey(nums[j])) {
                minDistance = Math.min(minDistance, j - indexMap.get(nums[j]));
            }

            // Store reverse(nums[j]) → j, overwriting older index (only need the latest)
            int reversed = reverseDigits(nums[j]);
            indexMap.put(reversed, j);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int reverseDigits(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + (num % 10);
            num /= 10;
        }
        return reversed;
    }
}