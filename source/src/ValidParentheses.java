public class ValidParentheses {
    /*
     * 题 目：有效的括号
     * 链 接：https://leetcode-cn.com/problems/valid-parentheses/
     * 描 述：给定一个只包括 '('，')'，'{'，'}'，'['，']'  的字符串 s ，判断字符串是否有效。
     *       有效字符串需满足：
     *       左括号必须用相同类型的右括号闭合。
     *       左括号必须以正确的顺序闭合。
     * */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        char[] stack = new char[s.length()];
        int head = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack[head++] = c;
                    break;
                case ')':
                    if (head == 0 || stack[--head] != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (head == 0 || stack[--head] != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (head == 0 || stack[--head] != '[') {
                        return false;
                    }
                    break;
            }
        }
        return head == 0;
    }

    public static void main(String[] args) {
        String s = "]";
        ValidParentheses validParentheses = new ValidParentheses();
        boolean re = validParentheses.isValid(s);
        System.out.println(re);
    }
}
