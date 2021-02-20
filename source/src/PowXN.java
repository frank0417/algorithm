public class PowXN {
    /*
     * 题 目：Pow(x, n)
     * 链 接: https://leetcode-cn.com/problems/powx-n/
     * 描 述：实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
     */
    public double myPow(double x, int n) {
        if (n == 0 || x == 1.0) return 1.0;
        if (n == 1) return x;
        long N=n;//这里注意转换类型，否则当参数n为int max时，报栈溢出的错误
        return N < 0 ? 1 / pow(x, -1 * N) : pow(x, N);
    }

    public double pow(double x, long n) {
        if (n == 1) return x;
        double result = pow(x, n / 2);
        return n % 2 == 1 ? result * result * x : result * result;
    }

    public static void main(String[] args) {
        PowXN p = new PowXN();
        System.out.println(p.myPow(2, 4));
    }


}
