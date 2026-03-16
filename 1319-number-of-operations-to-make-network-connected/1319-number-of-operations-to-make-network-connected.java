class Solution {
    public int makeConnected(int n, int[][] connections) {

        int parent[] = new int[n];
        int rank[] = new int[n];

        if (connections.length < n - 1) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int ans = n;

        for (int c[] : connections) {
            int u = c[0];
            int v = c[1];

            int up = find(u, parent);
            int vp = find(v, parent);

            if (up != vp) {
                ans--;
                union(u, v, parent, rank);
            }

        }

        return ans - 1;
    }

    int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }

        return parent[i] = find(parent[i], parent);
    }

    void union(int u, int v, int[] parent, int[] rank) {
        int up = find(u, parent);
        int vp = find(v, parent);

        if (up == vp) {
            return;
        }

        if (rank[up] > rank[vp]) {
            parent[vp] = up;
        } else if (rank[up] < rank[vp]) {
            parent[up] = vp;
        } else {
            parent[up] = vp;
            rank[vp]++;
        }
    }
}