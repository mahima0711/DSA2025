class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        Map<Integer, Deque<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> indeg = new HashMap<>();
        Map<Integer, Integer> outdeg = new HashMap<>();

        int n = pairs.length;

        for (int[] p : pairs) {

            adj.computeIfAbsent(p[0], k -> new ArrayDeque<>()).add(p[1]);
            outdeg.put(p[0], outdeg.getOrDefault(p[0], 0) + 1);
            indeg.put(p[1], indeg.getOrDefault(p[1], 0) + 1);
        }

        int start = pairs[0][0];

        for (int node : adj.keySet())
        {
            int out = outdeg.getOrDefault(node, 0);
            int in = indeg.getOrDefault(node, 0);

            if(out - in == 1)
            {
                start = node;
                break;
            }
        }

        List<Integer> list = new ArrayList<>();

        dfs(start, adj, list);

        Collections.reverse(list);

        int[][] ans = new int[n][2];

        for (int i = 0; i < n; i++) {
            ans[i][0] = list.get(i);
            ans[i][1] = list.get(i + 1);
        }

        return ans;
    }

    void dfs(int u, Map<Integer, Deque<Integer>> adj, List<Integer> path) {

        Deque<Integer> list = adj.get(u);

        while (list != null && !list.isEmpty()) {

            int v = list.pollFirst();   // remove edge
            dfs(v, adj, path);
        }

        path.add(u);
    }
}