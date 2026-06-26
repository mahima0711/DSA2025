class Solution {

    int dp[][];

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        dp = new int[101][101];

        for (int i = 0; i < 101; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {

            if (i >= 1 && obstacleGrid[i - 1][0] == 1) {
                dp[i][0] = 0;
                obstacleGrid[i][0] = 1;
            } else if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int j = 0; j < n; j++) {
            if (j >= 1 && obstacleGrid[0][j - 1] == 1) {
                dp[0][j] = 0;
                obstacleGrid[0][j] = 1;
            } else if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

}