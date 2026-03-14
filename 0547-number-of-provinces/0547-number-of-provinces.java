class Solution {
    int V;
    public int findCircleNum(int[][] isConnected) {

        V= isConnected.length;

        if (V == 0) {
            return 0;
        }

        List<List<Integer>> adj = new ArrayList<>();

        boolean[] visited = new boolean[V];

        int countProvince = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                countProvince++;
                dfs(isConnected, i, visited);
            }

        }

        return countProvince;
    }

    void dfs(int[][] isConnected, int u, boolean[] visited) {
        visited[u] = true;

        for (int v=0; v < V ;v++) {
            if (!visited[v] && isConnected[u][v] == 1) {
                dfs(isConnected, v, visited);
            }
        }
    }
}