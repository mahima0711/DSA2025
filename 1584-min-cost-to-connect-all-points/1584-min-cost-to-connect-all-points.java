class Solution {

    static class Pair{
        int u;
        int wt;

        Pair(int u, int wt)
        {
            this.u = u;
            this.wt = wt;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        
        boolean vis[] = new boolean[points.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);

        pq.add(new Pair(0, 0));

        int ans=0;

        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();

            int u = curr.u;
            int wt = curr.wt;

            if(vis[u]) continue;

            vis[u] = true;

            ans += wt;

            for (int v = 0; v < points.length; v++) {

                if (!vis[v]) {

                    int dist =
                        Math.abs(points[u][0] - points[v][0]) +
                        Math.abs(points[u][1] - points[v][1]);

                    pq.add(new Pair(v, dist));
                }
            }
        }

        return ans;
    }
}