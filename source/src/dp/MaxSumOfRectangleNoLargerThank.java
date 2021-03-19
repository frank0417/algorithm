package dp;

public class MaxSumOfRectangleNoLargerThank {
    /*
     * 题 目：矩形区域不超过 K 的最大数值和
     * 链 接: https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
     * 描 述：给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int row = matrix.length;
        int col = matrix[0].length;

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < col; i++) {
            int[] sum = new int[row];
            for (int j = i; j < col; j++) {
                for (int r = 0; r < row; r++) {
                    sum[r] += matrix[r][j];
                }
                int curr = 0;
                int max = sum[0];
                for (int n : sum) {
                    curr = Math.max(n, curr + n);
                    max = Math.max(curr, max);
                    if (max == k) return max;
                }
                if (max < k) {
                    res = Math.max(max, res);
                } else {
                    for (int a = 0; a < row; a++) {
                        int currSum = 0;
                        for (int b = a; b < row; b++) {
                            currSum += sum[b];
                            if (currSum <= k) res = Math.max(currSum, res);
                        }
                    }
                    if (res == k) return res;
                }
            }
        }
        return res;
    }
}
