package dfs;

public class WordSearch {
    /*
     * 题 目：单词搜索
     * 链 接: https://leetcode-cn.com/problems/word-search/
     * 描 述：给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     *      单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     *      同一个单元格内的字母不允许被重复使用。
     */
    //时间复杂度O(n^2*m^2)空间复杂度O(m*n) n为层数

    private int row, col;
    private char[] wordArray;
    private boolean[][] visited;
    private int[][] direct = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};


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
        WordSearch wordSearch = new WordSearch();
        wordSearch.exist(new char[][]{{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }}, "ABCB");
        System.out.println(true);
    }
}
