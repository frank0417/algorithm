import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    /*
     * 题 目：电话号码的字母组合
     * 链 接: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
     * 描 述：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     */

    private Map<String, String> phoneMap = new HashMap<String, String>(8) {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return result;
        dfs(0, digits, new StringBuffer(""));
        return result;
    }

    private void dfs(int level, String digits, StringBuffer s) {
        if (level == digits.length()) {
            result.add(s.toString());
            return;
        }

        String chars = phoneMap.get(String.valueOf(digits.charAt(level)));

        for (int i = 0; i < chars.length(); ++i) {
            dfs(level + 1, digits, s.append(chars.charAt(i)));
            s.deleteCharAt(level);
        }

    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letter = new LetterCombinationsOfAPhoneNumber();
        List<String> strs = letter.letterCombinations("3");
        System.out.println(strs);

    }


}
