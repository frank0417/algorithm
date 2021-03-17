package array;

public class SearchInRotatedSortedArray {
    /*
     * 题 目：搜索旋转排序数组
     * 链 接: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
     * 描 述：给你旋转后的数组nums和一个整数target ，如果nums中存在这个目标值target,则返回它的索引，否则返回 -1 。
     */
    //时间复杂度O(m*n)空间复杂度O(1)
    public int search(int[] nums, int target) {
        int len=nums.length, left=0,right=len-1,mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[left]<=nums[mid]){
                if(nums[left]<=target && target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(nums[mid]<target && target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}
