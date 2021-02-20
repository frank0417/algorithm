public class AddDigits {
    /*
     * 题 目：各位相加
     * 链 接: https://leetcode-cn.com/problems/add-digits/
     * 描 述：给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     */
    public int addDigits(int num) {
        if (num == 0) return 0;
        int res = num % 9;
        if (res == 0) return 9;
        return num % 9;
    }
}
