import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    /*
     * 题 目：滑动窗口最大值
     * 链 接：https://leetcode-cn.com/problems/sliding-window-maximum/
     * 描 述：给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *       返回滑动窗口中的最大值。
     */
    public int[] slidingWindowMaximum(int[] nums, int k) {
        int len=0;
        if(nums==null || (len=nums.length)==0) return new int[0];
        Deque<Integer> dq=new ArrayDeque<>(k);
        int[] result=new int[len-k+1];
        for(int i=0;i<len;++i){
            if(!dq.isEmpty() && i-dq.getFirst()>k-1) dq.removeFirst();
            while(!dq.isEmpty() && nums[i] > nums[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                result[i-k+1]=nums[dq.getFirst()];
            }
        }
        return result;
    }


    public int[] slidingWindowMaximum1(int[] nums, int k) {
        int n = 0;
        if (nums == null || (n = nums.length) == 0) return new int[0];
        int[] res = new int[n - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < n; ++i) {
            int start = i - k;
            if (start >= 0) {
                pq.remove(nums[start]);
            }
            pq.offer(nums[i]);
            if (pq.size() == k) {
                res[i - k + 1] = pq.peek();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        s.slidingWindowMaximum(new int[]{7,2,4}, 2);
    }
}
