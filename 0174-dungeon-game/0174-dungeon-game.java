class Solution {

    int dp[][];

    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        dp = new int[201][201];

        for (int i = 0; i < 201; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    if (dungeon[i][j] > 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.abs(dungeon[i][j]) + 1;
                    }
                    continue;
                }

                int right = 0;
                int down = 0;

                if (j + 1 >= n) {
                    right = Integer.MAX_VALUE;
                } else {
                    right = dp[i][j + 1];
                }

                if (i + 1 >= m) {
                    down = Integer.MAX_VALUE;
                } else {
                    down = dp[i + 1][j];
                }

                int result = Math.min(right, down) - dungeon[i][j];

                dp[i][j] = result > 0 ? result : 1;
            }
        }

        return dp[0][0];
    }

}