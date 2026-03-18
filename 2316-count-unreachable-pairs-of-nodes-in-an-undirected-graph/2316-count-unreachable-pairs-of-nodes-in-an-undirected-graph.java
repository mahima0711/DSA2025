class Solution {
    public long countPairs(int n, int[][] edges) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int e[] : edges) {
            union(e[0], e[1], parent, rank);
        }

        for (int i = 0; i < n; i++) {
            int p = find(i, parent);

            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        long result = 0;
        long rem = n;

        for (int size : map.values()) {
            result += (long) size * (rem - size);
            rem -= size;
        }

        return result;

    }

    int find(int i, int[] parent) {
        if (i == parent[i]) {
            return i;
        }

        return parent[i] = find(parent[i], parent);
    }

    void union(int u, int v, int[] parent, int[] rank) {
        int pu = find(u, parent);

        int pv = find(v, parent);

        if (pu == pv) {
            return;
        }

        if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else {
            parent[pu] = pv;
            rank[pv]++;
        }
    }
}