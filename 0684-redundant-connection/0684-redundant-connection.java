class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        int parent[] = new int[n+1];

        int rank[] = new int[n+1];

        for(int i=1; i<=n; i++)
        {
            parent[i] = i;
        }

        for(int e[] : edges)
        {
            int u = e[0];
            int v = e[1];

            int up = find(u, parent);
            int vp = find(v, parent);

            if(up == vp)
            {
                return new int[]{u,v};
            }

            union(up, vp , parent, rank);
        }

        return new int[0];
    }

    int find(int i, int[] parent)
    {
        if(parent[i] == i)
        {
            return i;
        }

        return parent[i] = find(parent[i], parent);
    }

    void union(int u_parent, int v_parent, int parent[], int rank[])
    {

        if(u_parent == v_parent)
        {
            return;
        }

        if(rank[u_parent] > rank[v_parent])
        {
            parent[v_parent] = u_parent;
        }
        else if(rank[u_parent] < rank[v_parent])
        {
            parent[u_parent] = v_parent;
        }
        else
        {
            parent[u_parent] = v_parent;
            rank[v_parent]++;
        }
    }
}