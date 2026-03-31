class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] visited = new boolean[n];

        boolean[] pathVisited = new boolean[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int nei : graph[i]) {
                adj.get(i).add(nei);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(adj, visited, pathVisited, i)) {
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!pathVisited[i]) { 
                ans.add(i);
            }
        }

        return ans;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited, int i) {
        visited[i] = true;
        pathVisited[i] = true;

        for (int nei : adj.get(i)) {
            if (!visited[nei] && dfs(adj, visited, pathVisited, nei)) {
                return true;
            } else if (pathVisited[nei]) {
                return true;
            }
        }
        pathVisited[i] = false;
        return false;
    }
}