public class GetKthMagicNumber {
    /*
     * 题 目：第 k 个数
     * 链 接: https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
     * 描 述：有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
     */
    public int getkthMagicNumber(int k) {
        int[] array = new int[k];
        array[0] = 1;
        int p3 = 0, p5 = 0, p7 = 0;
        for (int i = 1; i < k; ++i) {
            int min = Math.min(Math.min(3 * array[p3], 5 * array[p5]), 7 * array[p7]);
            array[i] = min;
            if (min == 3 * array[p3]) p3++;
            if (min == 5 * array[p5]) p5++;
            if (min == 7 * array[p7]) p7++;
        }
        return array[k - 1];
    }

    public static void main(String[] args) {
        GetKthMagicNumber getKthMagicNumber=new GetKthMagicNumber();
        int n=getKthMagicNumber.getkthMagicNumber(251);
        System.out.println(n);
    }
}
