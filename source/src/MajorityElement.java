import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    /*
     * 题 目：多数元素
     * 链 接: https://leetcode-cn.com/problems/majority-element/description/
     * 描 述：给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于n/2的元素。
     *       你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */

    //hash
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > len / 2) {
                return nums[i];
            }
        }
        return 0;
    }

    //排序
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //摩尔投票
    public int majorityElement2(int[] nums) {
        int len = nums.length;
        int count = 1;
        int val = nums[0];
        for (int i = 1; i < len; ++i) {
            if(val==nums[i]){
                ++count;
            }else if(--count==0){
                val=nums[i];
                count=1;
            }
        }
        return val;
    }


    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        int n = m.majorityElement2(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(n);
    }
}
