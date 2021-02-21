import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /*
     * 题 目：N 皇后
     * 链 接: https://leetcode-cn.com/problems/n-queens/
     * 描 述：n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     */

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] queens = new char[n][n];
        for (int i = 0; i < queens.length; ++i) {
            for (int j = 0; j < queens.length; ++j) {
                queens[i][j] = '.';
            }
        }
        dsp(0, queens);
        return result;
    }

    private void dsp(int row, char[][] queens) {
        if (row == queens.length) {
            result.add(print(queens));
            return;
        }

        for (int i = 0; i < queens.length; ++i) {
            if (check(queens, row, i)) {
                queens[row][i] = 'Q';
                dsp(row + 1, queens);
                queens[row][i] = '.';
            } else {
                continue;
            }
        }

    }

    private boolean check(char[][] queens, int row, int col) {
        //col
        for (int i = 0; i < row; ++i) {
            if (queens[i][col] == 'Q') {
                return false;
            }
        }
        //pie
        for (int i = row - 1, j = col + 1; i > -1 && j < queens.length; --i, j++) {
            if (queens[i][j] == 'Q') return false;
        }
        //na
        for (int i = row - 1, j = col - 1; i > -1 && j > -1; --i, j--) {
            if (queens[i][j] == 'Q') return false;
        }
        return true;
    }


    public List<String> print(char[][] queens) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < queens.length; ++i) {
            result.add(new String(queens[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        NQueens queens = new NQueens();
        List<List<String>> result = queens.solveNQueens(5);
        System.out.println(result.toString());
    }

}
