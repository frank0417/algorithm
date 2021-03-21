public class UniquePathsII {
    /*
     * 题 目：不同路径II
     * 链 接: https://leetcode-cn.com/problems/unique-paths-ii/
     * 描 述：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *       机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     *       现在考虑网格中有障碍物。问总共有多少条不同的路径？
     */
    //时间复杂度O(m*n) 空间复杂度O(n)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int[] path = new int[n];
        for (int i = 0; i < n; ++i) {
            if (obstacleGrid[0][i] == 1) {
                path[i] = 0;
                break;
            } else {
                path[i] = 1;
            }
        }
        if (path[n - 1] == 0 && m == 1) return 0;
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j - 1] == 1) path[j - 1] = 0;
                if (obstacleGrid[i][j] != 1) {
                    path[j] += path[j - 1];
                } else {
                    path[j] = 0;
                }
            }
        }
        return path[n - 1];
    }

    public static void main(String[] args) {
        UniquePathsII uniquePaths = new UniquePathsII();
        int result = uniquePaths.uniquePathsWithObstacles(new int[][]{{0, 0}, {1, 1}, {0, 0}});

    }
}
