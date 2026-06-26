class Solution {

    int dp[][];

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        dp = new int[101][101];

        for (int i = 0; i < 101; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, m, n, obstacleGrid);
    }

    int solve(int i, int j, int m, int n, int[][] obstacleGrid) {

        if (i < 0 || i >= m || j < 0 || j >= n || obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(i, j + 1, m, n, obstacleGrid);

        int down = solve(i + 1, j, m, n, obstacleGrid);

        return dp[i][j] = right + down;
    }
}