package dp;

public class SurroundedRegions {
    /*
     * 题 目：被围绕的区域
     * 链 接: https://leetcode-cn.com/problems/surrounded-regions/
     * 描 述：给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     */
    //时间复杂度O(m*n)空间复杂度O(m*n)
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1)
                        && board[i][j] == 'O') {
                    dfs(i, j, m, n, board);
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j, int m, int n, char[][] board) {
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1 || board[i][j] == '#' || board[i][j] == 'X') return;
        if (board[i][j] == 'O') {
            board[i][j] = '#';
            dfs(i + 1, j, m, n, board);
            dfs(i - 1, j, m, n, board);
            dfs(i, j + 1, m, n, board);
            dfs(i, j - 1, m, n, board);
        }
    }
}
