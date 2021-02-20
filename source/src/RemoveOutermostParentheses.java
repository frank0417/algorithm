import java.util.Arrays;
import java.util.Stack;

public class RemoveOutermostParentheses {
    /*
     * 题 目： 删除最外层的括号
     * 链 接：https://leetcode-cn.com/problems/remove-outermost-parentheses/
     * 描 述：有效括号字符串为空  ("")、"(" + A + ")"  或  A + B，其中  A 和  B  都是有效的括号字符串，+  代表字符串的连接。例如，""，"()"，"(())()"  和  "(()(()))"  都是有效的括号字符串。
     */
    public String removeOuterParentheses(String S) {
        char[] strs = S.toCharArray();
        Stack<Integer> stack = new Stack();
        char[] res=new char[S.length()];
        int k=0;
        for(int i=0;i<strs.length;++i){
            if(strs[i]=='('){
                if(!stack.isEmpty()){
                    res[k++]=strs[i];
                }
                stack.push(i);
            }
            if(strs[i]==')'){
                stack.pop();
                if(!stack.isEmpty()){
                    res[k++]=strs[i];
                }
            }
        }
        return String.valueOf(Arrays.copyOfRange(res,0,k));
    }

    public static void main(String[] args) {
        RemoveOutermostParentheses r=new RemoveOutermostParentheses();
        r.removeOuterParentheses("(()())(())");
    }
}
