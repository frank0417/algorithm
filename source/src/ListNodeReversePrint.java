import java.util.Stack;

public class ListNodeReversePrint {
    /*
     * 题 目：最小的k个数
     * 链 接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
     * 描 述：输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     */
    public int[] reversePrint(ListNode head) {

        if (head == null) return new int[0];
        Stack<Integer> stack = new Stack();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    int[] res;
    int i;

    public int[] reversePrint1(ListNode head) {

        recur(head, 0);
        return res;
    }

    void recur(ListNode head, int count) {
        if (head == null) {
            res = new int[count];
            i = count - 1;
            return;
        }
        recur(head.next, count + 1);
        res[i - count] = head.val;
    }
}
