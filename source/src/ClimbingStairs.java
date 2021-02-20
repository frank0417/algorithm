public class ClimbingStairs {
    /*
     * 题 目：爬楼梯
     * 链 接：https://leetcode-cn.com/problems/climbing-stairs/
     * 描 述：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     */
    public int climbStairs(int n) {
        if (n < 3) return n;
        int[] res = new int[]{1, 2, 3};
        for (int i = 2; i < n; i++) {
            res[2] = res[1] + res[0];
            res[0] = res[1];
            res[1] = res[2];
        }
        return res[2];
    }

    public int climbStairs1(int n) {
        return recur(n);
    }

    public int recur(int n) {
        if (n <= 3) return n;
        return recur(n - 1) + recur(n - 2);
    }
}
