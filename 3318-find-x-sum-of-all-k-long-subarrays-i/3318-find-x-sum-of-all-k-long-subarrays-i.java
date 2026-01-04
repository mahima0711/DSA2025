class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
       
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Frequency map for current window
        Map<Integer, Integer> freqMap = new HashMap<>();

        int left = 0;
        int index = 0;

        for (int right = 0; right < n; right++) {

            // Add current element
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            // Shrink window if size exceeds k
            if (right - left + 1 > k) {
                int leftVal = nums[left];
                freqMap.put(leftVal, freqMap.get(leftVal) - 1);

                if (freqMap.get(leftVal) == 0) {
                    freqMap.remove(leftVal);
                }
                left++;
            }

            // When window size == k
            if (right - left + 1 == k) {

                // Convert map to list of entries
                List<Map.Entry<Integer, Integer>> list =
                        new ArrayList<>(freqMap.entrySet());

                // Sort by:
                // 1. Frequency descending
                // 2. Value descending
                list.sort((a, b) -> {
                    if (!a.getValue().equals(b.getValue())) {
                        return b.getValue() - a.getValue();
                    }
                    return b.getKey() - a.getKey();
                });

                int sum = 0;
                int count = 0;

                // Take top x elements
                for (Map.Entry<Integer, Integer> entry : list) {
                    if (count == x) break;
                    sum += entry.getKey() * entry.getValue();
                    count++;
                }

                result[index++] = sum;

            }
        }

        return result;
    }
}