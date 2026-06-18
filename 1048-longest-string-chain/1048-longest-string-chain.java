class Solution {

    int dp[][];

    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        dp = new int[1001][1001];

        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(words, 0, -1, n);
    }

    int solve(String[] words, int i, int p, int n) {
        if (i >= n) {
            return 0;
        }

        if (p != -1 && dp[i][p] != -1) {
            return dp[i][p];
        }

        int take = 0;
        if (p == -1 || checkPredecessor(words[i], words[p])) {
            take = 1 + solve(words, i + 1, i, n);
        }

        int skip = solve(words, i + 1, p, n);
        int ans = Math.max(take, skip);

        if (p != -1) {
            dp[i][p] = ans;
        }

        return ans;
    }

    boolean checkPredecessor(String longer, String shorter) {

        if (longer.length() != shorter.length() + 1)
            return false;

        int i = 0, j = 0;

        while (i < longer.length()) {

            if (j < shorter.length() &&
                    longer.charAt(i) == shorter.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j == shorter.length();
    }
}