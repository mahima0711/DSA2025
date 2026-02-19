class Solution {

    int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int getMaximumGold(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int maxGold = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, backTrack(grid, i, j));
                }
            }
        }

        return maxGold;
    }

    int backTrack(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return 0;

        int maxGold = 0;

        int originalValue = grid[i][j];
        grid[i][j] = 0;

        for (int k = 0; k < dir.length; k++) {
            int next_i = i + dir[k][0];
            int next_j = j + dir[k][1];

            maxGold = Math.max(maxGold, backTrack(grid, next_i, next_j));
        }

        grid[i][j] = originalValue;

        return maxGold + originalValue;
    }
}