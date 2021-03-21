public class ValidPerfectSquare {
    /*
     * 题 目：有效的完全平方数
     * 链 接: https://leetcode-cn.com/problems/valid-perfect-square/
     * 描 述：给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     */
    public boolean isPerfectSquare(int num) {
        long r = num;
        while (r * r > num) {
            r = (r + num / r) / 2;
        }
        return r * r == num;
    }

    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid = 0;
        while (left <= right) {
            mid = (right - left + 1) / 2 + left;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


}
