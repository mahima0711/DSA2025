class Solution {

    int dp[][];

    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m][n];

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    if (matrix[i][j] == 1) {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                    }
                }

                result += dp[i][j];
            }
        }

        return result;
    }

}