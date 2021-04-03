import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    /*
     * 题 目：有效的字母异位词
     * 链 接: https://leetcode-cn.com/problems/valid-anagram/description/
     * 描 述：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     */
    public boolean validAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        for (int i = 0; i < s1.length; ++i) {
            if (s1[i] != t1[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean validAnagram1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] table = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            table[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); ++i) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
