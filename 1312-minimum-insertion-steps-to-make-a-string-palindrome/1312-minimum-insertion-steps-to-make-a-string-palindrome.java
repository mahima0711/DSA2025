class Solution {

    int dp[][];

    public int minInsertions(String s) {

        int n = s.length();

        dp = new int[501][501];

        for (int i = 0; i < 501; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < 501; i++) {
            dp[i][i] = 0;
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (L == 2)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}