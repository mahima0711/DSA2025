class Solution {
    public boolean equationsPossible(String[] equations) {
        
        int[] parent = new int[26];
        int[] rank = new int[26];

        for(int i=0;i<26;i++)
        {
            parent[i] = i;
        }

        for(String s : equations)
        {
            if(s.charAt(1) == '=') //"a==b"
            {
                union(s.charAt(0) - 'a', s.charAt(3) - 'a', parent, rank);
            }
        }

        for(String s : equations)
        {
            if(s.charAt(1) =='!') // "a!=b"
            {
                int parent_first = find(s.charAt(0) - 'a', parent);
                int parent_second = find(s.charAt(3) - 'a', parent);

                if(parent_first == parent_second)
                {
                    return false;
                }
            }
        }

        return true;
    }

    int find(int i, int[] parent)
    {
        if(parent[i] == i)
        {
            return i;
        }

        return parent[i] = find(parent[i], parent);
    }

    void union(int u, int v, int[] parent, int[] rank)
    {
        int u_parent = find(u, parent);
        int v_parent = find(v, parent);

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
            v_parent++;
        }
    }
} 