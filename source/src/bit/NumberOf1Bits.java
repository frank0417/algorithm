package bit;

public class NumberOf1Bits {
    /*
     * 题 目：位1的个数
     * 链 接: https://leetcode-cn.com/problems/number-of-1-bits/
     * 描 述：编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     */
    public int hammingWeight(int n) {
        return n==0?0:hammingWeight(n&(~n+1)^n)+1;
    }
}
