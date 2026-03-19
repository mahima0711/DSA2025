class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        int[][] px = new int[n + 1][m + 1];
        int[][] py = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                int cx = (grid[i - 1][j - 1] == 'X') ? 1 : 0;
                int cy = (grid[i - 1][j - 1] == 'Y') ? 1 : 0;

                px[i][j] = cx + px[i - 1][j] + px[i][j - 1] - px[i - 1][j - 1];
                py[i][j] = cy + py[i - 1][j] + py[i][j - 1] - py[i - 1][j - 1];

                if (px[i][j] > 0 && px[i][j] == py[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}