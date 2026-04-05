class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] outDegree = new int[n + 1];
        int[] inDegree = new int[n+1];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < trust.length; i++) {
            int u = trust[i][0];
            int v = trust[i][1];

            adj.get(u).add(v);

            outDegree[u]++;

            inDegree[v]++;
        }

        for (int i = 1; i < outDegree.length; i++) {
            if (outDegree[i] == 0 && inDegree[i] == n-1) {
                return i;
            }
        }

        return -1;
    }
}