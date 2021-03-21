import java.util.Arrays;

public class UniquePaths {
    /*
     * 题 目：不同路径
     * 链 接: https://leetcode-cn.com/problems/unique-paths/
     * 描 述：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *       机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     *       问总共有多少条不同的路径？
     */
    //时间复杂度O(m*n) 空间复杂度O(m*n)
    public int uniquePaths(int m, int n) {
        int[][] points = new int[n][m];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                if (i == n - 1 && j == m - 1) {
                    points[n - 1][m - 1] = 1;
                } else if (i == n - 1 || j == m - 1) {
                    points[i][j] = 1;
                } else
                    points[i][j] = points[i + 1][j] + points[i][j + 1];
            }
        }
        return points[0][0];
    }


    //逐行遍历，时间复杂度O(m*n) 空间复杂度O(n)
    public int uniquePathsII(int m, int n) {
        int[] points = new int[n];
        Arrays.fill(points, 1);
        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                points[j]=points[j-1]+points[j];
            }
        }
        return points[n-1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int result = uniquePaths.uniquePathsII(1, 1);
        System.out.println(result);
    }
}
