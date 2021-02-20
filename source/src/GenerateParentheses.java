import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /*
     * 题 目：括号生成
     * 链 接：https://leetcode-cn.com/problems/generate-parentheses/
     * 描 述：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
     */

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recur(0, 0, n, "", result);
        return result;
    }

    private void recur(int left, int right, int n, String str, List<String> result) {
        if (left == n && right == n) {
            result.add(str);
        }

        if (left < n) {
            recur(left + 1, right, n, str + "(", result);
        }

        if (right < left) {
            recur(left, right + 1, n, str + ")", result);
        }
    }
}
