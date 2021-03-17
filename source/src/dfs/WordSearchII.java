package dfs;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    /*
     * 题 目：单词搜索 II
     * 链 接: https://leetcode-cn.com/problems/word-search-ii/
     * 描 述：给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
     *       单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
     */
    //时间复杂度O(n^2)空间复杂度O(n^2) n为层数

    private int row, col;
    private char[] wordArray;
    private boolean[][] visited;
    private int[][] direct = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (int i=0;i<words.length;++i) {
            if (exist(board, words[i])) result.add(words[i]);
        }

        return result;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) return false;
        row = board.length;
        col = board[0].length;
        wordArray = word.toCharArray();
        visited = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (dfs(i, j, 0, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int begin, char[][] board) {
        if (wordArray[begin] != board[x][y] || visited[x][y]) return false;
        if (begin == wordArray.length - 1) {
            return true;
        }
        visited[x][y] = true;
        for (int[] d : direct) {
            int newX = x + d[0];
            int newY = y + d[1];
            if (newX >= 0 && newX < row && newY >= 0 && newY < col) {
                if (dfs(newX, newY, begin + 1, board)) return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearchII wordSearchII=new WordSearchII();
        wordSearchII.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},new String[]{"oath","pea","eat","rain"});
        System.out.println(true);
    }
}
