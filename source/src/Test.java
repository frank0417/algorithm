import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        int[] a = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(111);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre=new ListNode();
        ListNode cur=pre;
        cur.next=head;
        ListNode next=null;
        if(head==null || head.next==null) return head;

        while(head.next!=null){
            cur.next=head.next;
            cur=head;
            next=head.next;
            head=next.next;
            next.next=cur;
            cur.next=head;
        }
        return pre.next;

    }


}
