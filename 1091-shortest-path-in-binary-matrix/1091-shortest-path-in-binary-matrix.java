class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // ⭐ start or end blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        
        int level =0;

        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};
        Queue<int[]> q = new LinkedList<>();

        grid[0][0] = 1;

        q.offer(new int[]{0,0});

      while (!q.isEmpty()) {

            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            int dist = grid[r][c];

            //  reached destination
            if (r == n - 1 && c == n - 1)
                return dist;

            for (int i = 0; i < 8; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n
                        && grid[nr][nc] == 0) {

                    grid[nr][nc] = dist + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}