class Solution {

    Integer dp[][];
    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;

        int n = matrix[0].length;

        dp = new Integer[m][n];

        // for(int i=0;i<101;i++)
        // {
        //  Arrays.fill(dp[i], -1);
        // }

       int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, solve(matrix, 0, j, m, n));
        }

        return ans;
    }

    int solve(int[][] matrix, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 100000000;
        }
        if (i == m - 1)
            return matrix[i][j];

            if(dp[i][j] != null)
            {
                return dp[i][j];
            }

        int down = matrix[i][j] + solve(matrix, i + 1, j, m, n);

        int leftD = matrix[i][j] + solve(matrix, i + 1, j - 1, m, n);

        int rightD = matrix[i][j] + solve(matrix, i + 1, j + 1, m, n);

        int result = Math.min(down, Math.min(leftD, rightD));

        return dp[i][j] = result;
    }
}