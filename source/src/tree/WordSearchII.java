package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    /*
     * 题 目：单词搜索 II
     * 链 接: https://leetcode-cn.com/problems/word-search-ii/
     * 描 述：给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
     *       单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
     */
    //时间复杂度O(m*n*avg(words len)^4)空间复杂度O(m*n)
    private int[][] direct = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        int row = board.length, cols = board[0].length;
        Trie trie = new Trie();
        for (int i = 0; i < words.length; ++i) trie.insert(words[i]);// avg len(word)*words
        for (int i = 0; i < row; ++i) { //m*n*4
            for (int j = 0; j < cols; ++j) {
                dfs(i, j, "", trie, board, result, row, cols);
            }
        }
        return new ArrayList<>(result);
    }


    private void dfs(int x, int y, String word, Trie trie, char[][] board, Set<String> result, int row, int cols) {
        if (x < 0 || y < 0 || x > row - 1 || y > cols - 1 || board[x][y] == '#') return;
        word += board[x][y];
        if (!trie.startsWith(word)) return;
        if (trie.search(word)) {
            result.add(word);
        }
        char temp = board[x][y];
        board[x][y] = '#';
        for (int i = 0; i < 4; ++i) {
            dfs(x + direct[i][0], y + direct[i][1], word, trie, board, result, row, cols);
        }
        board[x][y] = temp;
    }
}
