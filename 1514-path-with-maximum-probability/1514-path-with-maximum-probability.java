class Solution {

    static class Pair{

        int node;
        double dist;

        Pair(int node, double dist)
        {
            this.node = node;
            this.dist = dist;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        double[] distance = new double[n];

        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(new Pair(v, succProb[i]));
            adj.get(v).add(new Pair(u, succProb[i]));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));

        distance[start_node] = 1;

        pq.add(new Pair(start_node, 1));

        while(!pq.isEmpty())
        {
            Pair pair = pq.poll();

            int node = pair.node;

            double wt = pair.dist;

            if(wt < distance[node]) continue;

            for(Pair nei: adj.get(node))
            {
                int v = nei.node;
                double d = nei.dist;

                if(d * wt > distance[v])
                {
                    distance[v] = d * wt;
                    pq.offer(new Pair(v, distance[v]));
                }
            }
        }

        return distance[end_node];
    }
}