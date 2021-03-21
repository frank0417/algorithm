package dp;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    /*
     * 题 目：有效的数独
     * 链 接：https://leetcode-cn.com/problems/valid-sudoku/
     * 描 述：判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                char val = board[i][j];
                int boxIndex = i / 3 * 3 + j / 3;
                if (set.contains("r" + i + val) || set.contains("c" + j + val)
                        || set.contains("b" + boxIndex + val))
                    return false;
                set.add("r" + i + val);
                set.add("c" + j + val);
                set.add("b" + boxIndex + val);
            }
        }
        return true;
    }

    public boolean isValidSudokuII(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                int val = board[i][j] - '1';
                int boxIndex = i / 3 * 3 + j / 3;
                if (row[i][val] == 1 || col[j][val] == 1 || box[boxIndex][val] == 1) return false;
                row[i][val] = 1;
                col[j][val] = 1;
                box[boxIndex][val] = 1;
            }
        }
        return true;
    }
}
