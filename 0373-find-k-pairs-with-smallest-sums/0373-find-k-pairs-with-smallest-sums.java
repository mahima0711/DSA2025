class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0)
            return ans;

        //min-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) ->

                (nums1[a[0]] + nums2[a[1]])
                        - (nums1[b[0]] + nums2[b[1]])

        );

        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new int[] { i, 0 });
        }

        // while(!pq.isEmpty())
        // {
        //     System.out.println(pq.peek()[0]+" "+pq.peek()[1]);
        //     pq.poll();
        // }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1];

            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                pq.add(new int[] { i, j + 1 });
            }
        }

        return ans;
    }
}