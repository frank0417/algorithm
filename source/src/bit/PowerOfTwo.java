package bit;

public class PowerOfTwo {
    /*
     * 题 目：2的幂
     * 链 接: https://leetcode-cn.com/problems/power-of-two/
     * 描 述：给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
