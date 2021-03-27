package bit;

public class ReverseBits {
    /*
     * 题 目：颠倒二进制位
     * 链 接: https://leetcode-cn.com/problems/reverse-bits/
     * 描 述：颠倒给定的 32 位无符号整数的二进制位。
     */
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;++i){
            res<<=1;
            res+=1&n;
            n>>=1;
        }
        return res;
    }


}
