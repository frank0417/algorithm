package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathInBinaryMatrix {
    /*
     * 题 目：二进制矩阵中的最短路径
     * 链 接: https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
     * 描 述：给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
     */
    //时间复杂度O(m*n)空间复杂度O(m*n)
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] direct = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        int n = grid.length;
        if (grid[n - 1][n - 1] == 1) return 0;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<int[]> visited=new HashSet<>();
        visited.add(new int[]{0,0});
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()){
            int[] ma=queue.poll();
            for(int i=0;i<8;++i){
                if(grid[ma[0]+direct[i][0]][ma[1]+direct[i][1]]=='1') continue;
            }
        }
        return -1;
    }
}
