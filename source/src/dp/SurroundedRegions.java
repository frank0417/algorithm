package dp;

public class SurroundedRegions {
    /*
     * 题 目：被围绕的区域
     * 链 接: https://leetcode-cn.com/problems/surrounded-regions/
     * 描 述：给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     */


    public void solve(char[][] board) {
        int m = board.length, n = board[0].length, p = m * n;
        UnionFind uf = new UnionFind(m * n + 1);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    uf.union(p, i * n + j);
                }

                if (board[i][j] == 'O') {
                    if (i > 0 && board[i - 1][j] == 'O') uf.union(i * n + j, (i - 1) * n + j);
                    if (i + 1 < m && board[i + 1][j] == 'O') uf.union(i * n + j, (i + 1) * n + j);
                    if (j > 0 && board[i][j - 1] == 'O') uf.union(i * n + j, i * n + j - 1);
                    if (j + 1 < n && board[i][j + 1] == 'O') uf.union(i * n + j, i * n + j + 1);
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O' && !uf.isConnected(i * n + j, p)) {
                    board[i][j] = 'X';
                }
            }
        }
    }


    //时间复杂度O(m*n)空间复杂度O(m*n)
    public void solveII(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1)
                        && board[i][j] == 'O') {
                    dfs(i, j, m, n, board);
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j, int m, int n, char[][] board) {
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1 || board[i][j] == '#' || board[i][j] == 'X') return;
        if (board[i][j] == 'O') {
            board[i][j] = '#';
            dfs(i + 1, j, m, n, board);
            dfs(i - 1, j, m, n, board);
            dfs(i, j + 1, m, n, board);
            dfs(i, j - 1, m, n, board);
        }
    }
}

class UnionFind {
    int count = 0;
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

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
