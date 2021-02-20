import java.util.Stack;

public class MinStack {

    /*
     * 题 目：最小栈
     * 链 接：https://leetcode-cn.com/problems/min-stack/
     * 描 述：设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     */

    private Stack<Integer> data;
    private Stack<Integer> data1;

    public MinStack() {
        data = new Stack<>();
        data1 = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (data1.empty() || data1.peek() >= x) {
            data1.push(x);
        }else{
            int a=data1.peek();
            data1.push(a);
        }
    }

    public void pop() {
        data.pop();
        data1.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return data1.peek();
    }


}
