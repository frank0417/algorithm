import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    /*
     * 题 目：合并K个升序链表
     * 链 接: https://leetcode-cn.com/problems/merge-k-sorted-lists/
     * 描 述：给你一个链表数组，每个链表都已经按升序排列。
     *       请你将所有链表合并到一个升序链表中，返回合并后的链表。
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                return 1;
            }
        });

        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode();
        ListNode p = dummy;

        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            p.next = min;
            queue.add(min.next);
        }
        return dummy.next;


    }


}
