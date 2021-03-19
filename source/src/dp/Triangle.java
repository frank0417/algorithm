package dp;

import java.util.List;

public class Triangle {
    /*
     * 题 目：三角形最小路径和
     * 链 接: https://leetcode-cn.com/problems/triangle
     * 描 述：给定一个三角形 triangle ，找出自顶向下的最小路径和。
     */
    //时间复杂度O(n^2)空间复杂度O(n^2) n为层数
    public int minimumTotal(List<List<Integer>> triangle) {
        int size=triangle.size();
        int dp[][]=new int[size+1][size+1];
        for(int i=size-1;i>=0;--i){
            for(int j=0;j<=i;j++){
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    //时间复杂度O(n^2)空间复杂度O(n) n为层数
    public int minimumTotalII(List<List<Integer>> triangle) {
        int size=triangle.size();
        int dp[]=new int[size+1];
        for(int i=size-1;i>=0;--i){
            for(int j=0;j<=i;j++){
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    //时间复杂度O(n^2)空间复杂度O(1) n为层数  工程上不建议直接修改参数
    public int minimumTotalIII(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }
}
