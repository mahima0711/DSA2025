class Solution {

    int dp[][];

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new int[201][201];

        for (int i = 0; i < 201; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(grid, 0, 0, m, n);
    }

    int solve(int[][] grid, int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(grid, i, j + 1, m, n);
        int down = solve(grid, i + 1, j, m, n);

        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }
}