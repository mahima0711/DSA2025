class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {

        List<Integer> ans = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < bulbs.size(); i++) {
            map.put(bulbs.get(i), 0);
        }

        for (int i = 0; i < bulbs.size(); i++) {
            if (map.containsKey(bulbs.get(i))) {
                if (map.get(bulbs.get(i)) == 0) {
                    map.put(bulbs.get(i), 1);
                } else {
                    map.put(bulbs.get(i), 0);
                }

            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                ans.add(key);
            }
        }

        Collections.sort(ans);

        return ans;
    }
}