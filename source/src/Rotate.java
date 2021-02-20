
public class Rotate {
    /*
     * 题 目：旋转数组
     * 链 接：https://leetcode-cn.com/problems/rotate-array/
     * 描 述：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     */
    public void rotate(int[] nums, int k) {
        int length = 0;
        if (nums == null || (length = nums.length) == 0 || k<1) return;
        k%=length;
        reverse(nums,0,length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,length-1);
    }

    public void reverse(int[] nums,int start,int end){
        while(start<end){
            int tmp=nums[start];
            nums[start++]=nums[end];
            nums[end--]=tmp;
        }
    }
}
