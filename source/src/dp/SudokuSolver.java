package dp;

import java.util.Arrays;

public class SudokuSolver {
    /*
     * 题 目：解数独
     * 链 接：https://leetcode-cn.com/problems/sudoku-solver/
     * 描 述：编写一个程序，通过填充空格来解决数独问题。
     */
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; ++k) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char k) {
        for (int c = 0; c < 9; ++c) {
            if (board[i][c] == k || board[c][j] != '.' && board[c][j] == k ||
                    board[i / 3 * 3 + c / 3][j / 3 * 3 + c % 3] == k)
                return false;
        }
        return true;
    }


    public void solveSudokuII(char[][] board) {
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int d) {
        if (d == 81) return true;
        int i = d / 9, j = d % 9;
        if (board[i][j] != '.') return dfs(board, d + 1);

        boolean[] flag = new boolean[10];
        validate(board, i, j, flag);
        for (int k = 1; k <= 9; k++) {
            if (flag[k]) {
                board[i][j] = (char) ('0' + k);
                if (dfs(board, d + 1)) return true;
            }
        }
        board[i][j] = '.';
        return false;
    }

    private void validate(char[][] board, int i, int j, boolean[] flag) {
        Arrays.fill(flag, true);
        for (int k = 0; k < 9; k++) {
            if (board[i][k] != '.') flag[board[i][k] - '0'] = false;
            if (board[k][j] != '.') flag[board[k][j] - '0'] = false;
            int r = i / 3 * 3 + k / 3;
            int c = j / 3 * 3 + k % 3;
            if (board[r][c] != '.') flag[board[r][c] - '0'] = false;
        }
    }


}
