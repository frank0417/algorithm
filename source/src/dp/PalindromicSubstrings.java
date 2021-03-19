package dp;

public class PalindromicSubstrings {
    /*
     * 题 目：回文子串
     * 链 接: https://leetcode-cn.com/problems/palindromic-substrings/
     * 描 述：给定一个字符，你的任务是计算这个字符串中有多少个回文子串。
     *       具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     */
    //时间复杂度O(n^2)空间复杂度O(n^2)
    public int countSubstrings(String s) {
        int len = 0, result = 0;
        if (s == null || (len = s.length()) == 0) return 0;
        boolean dp[][] = new boolean[len][len];
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    result++;
                }
            }
        }
        return result;
    }

    //时间复杂度O(n)空间复杂度O(n)
    public int countSubstringsII(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');
        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            ans += f[i] / 2;
        }
        return ans;
    }

    //时间复杂度O(n^2)空间复杂度O(1)
    public int countSubstringsIII(String s) {
        int res = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j); j++) res++;
            for (int j = 0; i - 1 - j >= 0 && i + j < n && s.charAt(i - 1 - j) == s.charAt(i + j); j++) res++;
        }
        return res;
    }
}
