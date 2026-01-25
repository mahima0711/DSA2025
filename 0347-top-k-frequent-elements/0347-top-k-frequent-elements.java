class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(map.get(a), map.get(b))
        );

        for(Integer i : map.keySet())
        {
            pq.add(i);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }

        int[] ans = new int[k];

        for(int i=0;i<ans.length;i++)
        {
            ans[i] = pq.poll();
        }

        return ans;
    }
}