import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
     * 题 目：两数之和
     * 链 接: https://leetcode-cn.com/problems/two-sum/
     * 描 述：给定一个整数数组 nums  和一个整数目标值 target，请你在该数组中找出 和为目标值 的那  两个  整数，并返回它们的数组下标。
     *       你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *       你可以按任意顺序返回答案。
     */

    public int[] twoSum(int[] nums, int target) {
        int length = 0;
        if (nums == null || (length = nums.length) < 2) return null;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < length; ++i) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
