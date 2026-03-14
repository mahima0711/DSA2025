class Solution {
    public int findCircleNum(int[][] isConnected) {

        int V = isConnected.length;

        if (V == 0) {
            return 0;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // build adjacency list from matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[V];

        int countProvince = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                countProvince++;
                dfs(adj, i, visited);
            }

        }

        return countProvince;
    }

    void dfs(List<List<Integer>> adj, int u, boolean[] visited) {
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(adj, v, visited);
            }
        }
    }
}