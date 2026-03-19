class Solution {

    static class Pair{
        int node;
        int dist;

        Pair(int node, int dist)
        {
            this.node = node;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();


        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int t[] : times)
        {
            int u = t[0];
            int v = t[1];
            int wt = t[2];

            adj.get(u).add(new Pair(v, wt));
        }

        int[] result = new int[n+1];

        Arrays.fill(result, Integer.MAX_VALUE);

        result[k] = 0;
 
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);

        pq.add(new Pair(k, 0));

        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();

            int node = curr.node; //2
            int dist = curr.dist; //0

            if(dist > result[node]) continue;

            for(Pair nei : adj.get(node))
            {
                int v = nei.node; // 1
                int wt = nei.dist; // 1

                if(dist + wt < result[v])
                {
                    result[v] = dist + wt;

                    pq.add(new Pair(v, result[v]));
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (result[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, result[i]);
        }

        return ans;
    }
}