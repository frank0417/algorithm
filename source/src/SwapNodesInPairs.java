public class SwapNodesInPairs {
    /*
     * 题 目：两两交换链表中的节点
     * 链 接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
     * 描 述：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     */
    public ListNode swapPairs(ListNode head){
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null && cur.next!=null){
            next=cur.next;
            cur.next=next.next;
            next.next=cur;
            pre.next=next;

            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }


}
