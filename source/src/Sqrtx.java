public class Sqrtx {
    /*
     * 题 目：x 的平方根
     * 链 接: https://leetcode-cn.com/problems/sqrtx/
     * 描 述：计算并返回 x 的平方根，其中 x 是非负整数。
     */
    public int mySqrt(int x) {
        return 0;
    }

    //牛顿迭代
    public int mySqrtII(int x) {
        int r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return r;
    }
}
