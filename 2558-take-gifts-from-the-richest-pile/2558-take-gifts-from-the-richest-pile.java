class Solution {
    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < gifts.length; i++) {
            pq.add(gifts[i]);
        }

        int count = k;

        while (k > 0) {
            int max = pq.poll();
            pq.add((int) Math.sqrt(max));
            k--;
        }

        long ans = 0L;

        while (!pq.isEmpty()) {
            ans += pq.poll();
        }

        return ans;
    }
}