class Solution {

    static class Pair {
        int u;
        int price;

        Pair(int u, int price) {
            this.u = u;
            this.price = price;
        }
    }
    static class Tuple {
        int node, cost, stops;

        Tuple(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] f : flights) {
            adj.get(f[0]).add(new Pair(f[1], f[2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(src, 0, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {
            Tuple curr = q.poll();

            int node = curr.node;
            int cost = curr.cost;
            int stops = curr.stops;

            if (stops > k) continue;

            for (Pair nei : adj.get(node)) {
                int next = nei.u;
                int newCost = cost + nei.price;

                if (newCost < dist[next] && stops <= k) {
                    dist[next] = newCost;
                    q.add(new Tuple(next, newCost, stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}