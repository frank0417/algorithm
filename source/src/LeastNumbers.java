import java.util.PriorityQueue;

public class LeastNumbers {
    /*
     * 题 目：最小的k个数
     * 链 接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
     * 描 述：输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     */
    public int[] getLeastNumbers(int[] nums, int k) {
        int length = 0;
        if (nums == null || (length = nums.length) <= k) return nums;
        int[] res = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < length; ++i) {
            pq.add(nums[i]);
        }

        for (int i = 0; i < k; ++i) {
            res[i] = pq.poll();
        }
        return res;
    }
}





