package dp;

public class MinimumPathSum {
    /*
     * 题 目：最小路径和
     * 链 接: https://leetcode-cn.com/problems/minimum-path-sum/
     * 描 述：给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     */
    //时间复杂度O(m*n)空间复杂度O(1)
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < m; i++) grid[i][0] = grid[i][0] + grid[i - 1][0];
        for (int i = 1; i < n; i++) grid[0][i] = grid[0][i] + grid[0][i - 1];
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int result = minimumPathSum.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(result);
    }
}
