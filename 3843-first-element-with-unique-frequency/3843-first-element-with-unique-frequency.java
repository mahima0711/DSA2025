class Solution {
    public int firstUniqueFreq(int[] nums) {

        Map<Integer,Integer> map = new LinkedHashMap<>();

        int unique =-1;

        for (int i = 0; i < nums.length; i++) {
          map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        Map<Integer, Integer> count = new LinkedHashMap<>();

        for (Map.Entry<Integer, Integer> m: map.entrySet()) {
            System.out.println(m.getKey() + " "+ m.getValue());
            count.put(m.getValue(), count.getOrDefault(m.getValue(), 0)+1);
        }

        int freq =0;

        for (Map.Entry<Integer, Integer> check: count.entrySet()) {
            if(check.getValue() == 1)
            {
                freq = check.getKey();
                break;
            }
        }

        for (Map.Entry<Integer, Integer> m: map.entrySet()) {
            if(m.getValue() == freq)
            {
                unique = m.getKey();
                break;
            }
        }

        return unique;
    }
}