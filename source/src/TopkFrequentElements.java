import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class TopkFrequentElements {
    /*
     * 题 目：前 K 个高频元素
     * 链 接：https://leetcode-cn.com/problems/top-k-frequent-elements/
     * 描 述：给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     */
    public int[] topKFrequent(int[] nums, int k) {
        int n = 0;
        if (nums == null || (n = nums.length) == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        int[] res = new int[k];
        for (int i = 0; i < n; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 1) + 1);
        }

        for (Integer key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) pq.poll();
        }

        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }

}
