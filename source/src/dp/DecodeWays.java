package dp;

public class DecodeWays {
    /*
     * 题 目：解码方法
     * 链 接: https://leetcode-cn.com/problems/decode-ways/
     * 描 述：给你一个只含数字的非空字符串num ，请计算并返回解码方法的总数 。
     */
    //时间复杂度O(m*n)空间复杂度O(1)
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;
        int[] dp = new int[chars.length];
        dp[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '0') {
                if (chars[i - 1] != '1' && chars[i - 1] != '2') return 0;
                dp[i] = i == 1 ? 1 : dp[i - 2];
            } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] >= '1' && chars[i] <= '6')) {
                dp[i] = i == 1 ? dp[i - 1] + 1 : dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[chars.length - 1];
    }
}
