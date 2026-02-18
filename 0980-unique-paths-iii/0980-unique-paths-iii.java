class Solution {

    int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    int nonObstacle;
    int ans;

    public int uniquePathsIII(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int start_i = 0;
        int start_j = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    start_i = i;
                    start_j = j;
                } else if (grid[i][j] == 0) {
                    nonObstacle++;
                }
            }
        }

        nonObstacle +=1;

        int count=0;

        backTrack(grid, count, start_i, start_j);

        return ans;
    }

    private void backTrack(int[][] grid, int count, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1)
            return;


        if (grid[x][y] == 2) {

            if (nonObstacle == count) {
                ans++;
            }
            return;
        }


        grid[x][y] = -1;

        for (int[] d : dir) {
            int new_x = x + d[0];
            int new_y = y + d[1];
            backTrack(grid, count + 1, new_x, new_y);
        }

        grid[x][y] = 0;
    }
}