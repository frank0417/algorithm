public class ReverseList {
    /*
     * 题 目：反转链表
     * 链 接：https://leetcode-cn.com/problems/reverse-linked-list/
     * 描 述：反转一个单链表。
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur.next != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}

