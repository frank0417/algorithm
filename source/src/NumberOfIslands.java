public class NumberOfIslands {
    /*
     * 题 目：岛屿数量
     * 链 接：https://leetcode-cn.com/problems/number-of-islands/
     * 描 述：给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *       岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *       此外，你可以假设该网格的四条边均被水包围
     */
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int countZero = 0;
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '0') {
                    countZero++;
                    continue;
                }
                if (j > 0 && grid[i][j - 1] == '1') uf.union(i * n + j, i * n + j - 1);
                if (j + 1 < n && grid[i][j + 1] == '1') uf.union(i * n + j, i * n + j + 1);
                if (i > 0 && grid[i - 1][j] == '1') uf.union(i * n + j, (i - 1) * i + j);
                if (i + 1 < m && grid[i + 1][j] == '1') uf.union(i * n + j, (i + 1) * n + j);
            }
        }
        return uf.count - countZero;
    }
}

class UnionFind {
    int count;
    int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }
}
