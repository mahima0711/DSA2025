class Solution {
    public int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;
        int ans[] = new int[n];

        PriorityQueue<int[]> minStart = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> minEnd = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            ans[i] = -1;
            minStart.add(new int[] { intervals[i][0], i });
            minEnd.add(new int[] { intervals[i][1], i });

        }

        while (!minStart.isEmpty() && !minEnd.isEmpty()) {
            int[] startEle = minStart.peek();

            int start = startEle[0];
            int startIdx = startEle[1];

            if (start >= minEnd.peek()[0]) {
                ans[minEnd.peek()[1]] = startIdx;
                minEnd.poll();
            } else {
                minStart.poll();
            }
        }

        return ans;
    }
}