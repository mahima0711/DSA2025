class Solution {

    int dp[][];

    public int minInsertions(String s) {

        int n = s.length();

        dp = new int[501][501];

        for (int i = 0; i < 501; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i=0;i<501;i++)
        {
            dp[i][i] = 0;
        }

        return solve(s, 0, n - 1, n);
    }

    int solve(String s, int i, int j, int n) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(s, i + 1, j - 1, n);
        } else {
            return dp[i][j] = 1 + Math.min(solve(s, i, j - 1, n), solve(s, i + 1, j, n));
        }

    }
}