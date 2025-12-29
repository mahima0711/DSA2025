class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
         Map<String, Integer> map = new HashMap<>();

        // Store index of list1 items
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        // Traverse list2
        for (int j = 0; j < list2.length; j++) {
            String word = list2[j];

            if (map.containsKey(word)) {
                int idxSum = j + map.get(word);

                if (idxSum < minSum) {
                    result.clear();          // New better sum found
                    result.add(word);
                    minSum = idxSum;
                } 
                else if (idxSum == minSum) {
                    result.add(word);        // Same minimum → add
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }
}