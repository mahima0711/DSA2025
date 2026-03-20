class Solution {

    static class Pair{
        int r;
        int c;
        int effort;

        Pair(int r, int c, int effort)
        {
            this.r = r;
            this.c = c;
            this.effort = effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
int m = heights[0].length;

        int result[][] = new int[n][m];

        int[][] directions = {
            {-1,0}, {0,-1}, {0,1}, {1,0}
        };

        for(int i=0;i<n;i++)
        {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.effort - b.effort);

        pq.offer(new Pair(0,0,0));

        result[0][0] = 0;

        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();

            int r = curr.r;
            int c = curr.c;
            int e = curr.effort;

            if(e > result[r][c]) continue;

            if(r == n-1 && c == m-1)
            {
                return e;
            }

            for(int drc[] : directions)
            {
                int nr = r + drc[0];
                int nc = c + drc[1];

                if(nr >=0 && nc >=0 && nr < n && nc < m)
                {
                    int diff = Math.abs(
                            heights[nr][nc] - heights[r][c]);

                    int newEffort = Math.max(e, diff);

                    if (newEffort < result[nr][nc]) {
                        result[nr][nc] = newEffort;
                        pq.offer(new Pair(nr, nc, newEffort));
                    }
                }
            }

        }

        return 0;
    }
}