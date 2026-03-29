class Solution {
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // First & last column
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        // First & last row
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // captured
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O'; // safe restore
                }
            }
        }
    }

    void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || j >= board[0].length || i >= board.length) {
            return;
        }

        // only process 'O'
        if (board[i][j] != 'O') {
            return;
        }

        // mark safe
        board[i][j] = '#';

        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}