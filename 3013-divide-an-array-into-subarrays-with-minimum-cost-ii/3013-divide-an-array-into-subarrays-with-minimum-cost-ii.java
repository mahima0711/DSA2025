class Solution {
    public long minimumCost(int[] nums, int k, int dist) {

        //NOT SELF SOLVED
        long ans = Long.MAX_VALUE; // Initialize the answer with the maximum possible value
        long cur = 0; // Track the current sum of the smallest 'k' elements in the window
        k--; // Adjust 'k' to match the problem's requirements

        // Use two sets to maintain the smallest 'k' elements and the remaining elements
        // 'actual' will store the smallest 'k' elements, and 'notUsed' will store the rest
        java.util.TreeSet<java.util.AbstractMap.SimpleEntry<Integer, Integer>> actual = new java.util.TreeSet<>(
                (a, b) -> {
                    if (!a.getKey().equals(b.getKey()))
                        return a.getKey().compareTo(b.getKey());
                    return a.getValue().compareTo(b.getValue());
                });
        java.util.TreeSet<java.util.AbstractMap.SimpleEntry<Integer, Integer>> notUsed = new java.util.TreeSet<>(
                (a, b) -> {
                    if (!a.getKey().equals(b.getKey()))
                        return a.getKey().compareTo(b.getKey());
                    return a.getValue().compareTo(b.getValue());
                });

        // Use two pointers to represent the sliding window
        int l = 1, r = 1;
        while (r < nums.length) {
            // Ensure the window size does not exceed 'dist'
            while (r - l > dist) {
                // If the element at 'l' is in 'actual', remove it and adjust the sum
                if (actual.contains(new java.util.AbstractMap.SimpleEntry<>(nums[l], l))) {
                    cur -= nums[l];
                    actual.remove(new java.util.AbstractMap.SimpleEntry<>(nums[l], l));
                }

                // If the element at 'l' is in 'notUsed', remove it
                if (notUsed.contains(new java.util.AbstractMap.SimpleEntry<>(nums[l], l))) {
                    notUsed.remove(new java.util.AbstractMap.SimpleEntry<>(nums[l], l));
                }

                l++; // Move the left pointer
            }

            // Add the new element at 'r' to 'notUsed'
            notUsed.add(new java.util.AbstractMap.SimpleEntry<>(nums[r], r));

            // If 'actual' has fewer than 'k' elements, move elements from 'notUsed' to 'actual'
            while (actual.size() < k && !notUsed.isEmpty()) {
                java.util.AbstractMap.SimpleEntry<Integer, Integer> smallest = notUsed.first();
                actual.add(smallest);
                cur += smallest.getKey();
                notUsed.remove(smallest);
            }

            // Ensure 'actual' contains the smallest 'k' elements by swapping if necessary
            while (!notUsed.isEmpty() && !actual.isEmpty() && actual.last().getKey() > notUsed.first().getKey()) {
                java.util.AbstractMap.SimpleEntry<Integer, Integer> largestActual = actual.last();
                java.util.AbstractMap.SimpleEntry<Integer, Integer> smallestNotUsed = notUsed.first();

                // Swap the largest element in 'actual' with the smallest element in 'notUsed'
                actual.remove(largestActual);
                cur -= largestActual.getKey();
                notUsed.add(largestActual);

                actual.add(smallestNotUsed);
                cur += smallestNotUsed.getKey();
                notUsed.remove(smallestNotUsed);
            }

            // If 'actual' has exactly 'k' elements, update the answer
            if (actual.size() == k) {
                ans = Math.min(ans, cur);
            }

            r++; // Move the right pointer
        }

        // Return the total minimum cost, including the first element
        return ans + nums[0];
    }
}