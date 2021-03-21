public class MaximumSubarray {
    /*
     * 题 目：最大子序和
     * 链 接：https://leetcode-cn.com/problems/maximum-subarray/
     * 描 述：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */
    public int maxSubArray(int[] nums){
        int result=nums[0];
        int sum=0;
        for(int num:nums){
            if(sum+num>num){
                sum+=num;
            }else{
                sum=num;
            }
            result=Math.max(result,sum);
        }
        return result;
    }
}
