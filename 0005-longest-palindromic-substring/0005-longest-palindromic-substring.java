class Solution {

    int dp[][];

    public String longestPalindrome(String s) {

        int n = s.length();

        int maxLength = 0;

        int startIdx = 0;

        dp = new int[1001][1001];

        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (solve(i, j, s)) {
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        startIdx = i;
                    }
                }
            }
        }

        return s.substring(startIdx, startIdx + maxLength);
    }

    boolean solve(int i, int j, String s) {
        if (i >= j) {
            return true;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        if (s.charAt(i) == s.charAt(j) && solve(i + 1, j - 1, s)) {
            dp[i][j] = 1;
            return true;
        }

        dp[i][j] = 0;
        return false;
    }
}