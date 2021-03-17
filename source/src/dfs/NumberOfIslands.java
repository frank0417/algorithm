package dfs;

public class NumberOfIslands {
    /*
     * 题 目：岛屿数量
     * 链 接：https://leetcode-cn.com/problems/climbing-stairs/
     * 描 述：给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *       岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *       此外，你可以假设该网格的四条边均被水包围。
     */

    private int m, n;

    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || (m = grid.length) == 0) return 0;
        n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > m-1 || j > n-1 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        numberOfIslands.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
    }
}
