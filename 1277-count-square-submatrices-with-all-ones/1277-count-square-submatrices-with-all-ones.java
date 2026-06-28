class Solution {

    int dp[][];

    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m][n];

        for(int i=0;i<m;i++)
        {
            Arrays.fill(dp[i], -1);
        }

        int count =0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j] == 1)
                {
                    count += solve(matrix, i, j, m, n);
                }
            }
        }

        return count;
    }

    int solve(int[][] arr, int i, int j, int m, int n)
    {
        if(i >= m || j>=n)
        {
            return 0;
        }

        if(arr[i][j] == 0)
        {
            return 0;
        }

        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }

        int right = solve( arr, i, j+1, m,n);

        int dia = solve(arr, i+1, j+1, m, n);
        int down = solve(arr, i+1, j, m, n);

        int result = 1 + Math.min(right, Math.min(dia, down));

        return dp[i][j] = result;

    }
}