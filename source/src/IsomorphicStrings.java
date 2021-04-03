import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    /*
     * 题 目：同构字符串
     * 链 接：https://leetcode-cn.com/problems/isomorphic-strings/
     * 描 述：给定两个字符串 s 和 t，判断它们是否是同构的。
     *       如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     *       每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
     *       相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> maps = new HashMap<>();
        Map<Character, Character> mapt = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if (!maps.containsKey(x)) maps.put(x, y);
            if (!mapt.containsKey(y)) mapt.put(y, x);
            if (maps.get(x) != y || mapt.get(y) != x) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphicII(String s, String t) {
        int[] m1 = new int[256], m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
