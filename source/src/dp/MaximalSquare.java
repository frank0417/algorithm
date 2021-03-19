package dp;


public class MaximalSquare {
    /*
     * 题 目：最大正方形
     * 链 接: https://leetcode-cn.com/problems/maximal-square/
     * 描 述：在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     */
    //时间复杂度O(m*n)空间复杂度O(n)
    public int maximalSquare(char[][] matrix) {
        if (matrix == null) return 0;
        int row = matrix.length, col = matrix[0].length, max = 0;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; ++i) {
            for (int j = 1; j <= col; ++j) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        maximalSquare.maximalSquare(new char[][]{{'1', '0', '1', '0', '0' }, {'1', '0', '1', '1', '1' }, {'1', '1', '1', '1', '1' }, {'1', '0', '0', '1', '0' }});
    }
}
