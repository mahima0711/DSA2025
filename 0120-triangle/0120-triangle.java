class Solution {

    Integer dp[][];

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        dp = new Integer[n][n];

        // for(int i=0;i<n;i++)
        // {
        //     Arrays.fill(dp[i], -1);
        // }

        return solve(triangle, 0, 0, n);
    }

    int solve(List<List<Integer>> triangle, int i, int j, int n) {
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != null)
            return dp[i][j];

        int down = solve(triangle, i + 1, j, n);
        int diagonal = solve(triangle, i + 1, j + 1, n);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
    }
}