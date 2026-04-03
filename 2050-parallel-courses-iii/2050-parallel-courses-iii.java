class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {

        List<List<Integer>> adj = new ArrayList<>();

        int indegree[] = new int[n + 1];
        int maxTime[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int r[] : relations) {
            adj.get(r[0]).add(r[1]);
            indegree[r[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                maxTime[i] = time[i - 1];
            }
        }

        int monthsNeeded = 0;

        while (!queue.isEmpty()) {

            int curr = queue.poll();

            for (int nei : adj.get(curr)) {
                indegree[nei]--;

                maxTime[nei] = Math.max(maxTime[nei], maxTime[curr] + time[nei-1]);

                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }

        }

        for(int i =1; i<=n ;i++)
        {
            monthsNeeded = Math.max(monthsNeeded, maxTime[i]);
        }

        return monthsNeeded;
    }
}