class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int[][] arr = new int[profits.length][2];

        for (int i = 0; i < profits.length; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }

        Arrays.sort(arr,
                (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int idx = 0;
        while (k > 0) {

            while (idx < profits.length) {
                if (arr[idx][0] > w) {
                    break;
                } else {
                    pq.add(arr[idx][1]);
                    idx++;
                }
            }
            if (pq.isEmpty()) break;
            int m = pq.poll();
            w += m;
            k--;
        }

        return w;
    }
}