public class SearchA2dMatrix {
    /*
     * 题 目：搜索二维矩阵
     * 链 接：https://leetcode-cn.com/problems/search-a-2d-matrix/
     * 描 述：编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     *       每行中的整数从左到右按升序排列。
     *       每行的第一个整数大于前一行的最后一个整数。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m - 1, mid,temp=0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if(matrix[mid][0]>=target && matrix[mid][n-1]<=target){
               temp=target;
               break;
            }
            if (matrix[mid][n - 1] > target) {
                right = mid - 1;
            } else if (matrix[mid][n - 1] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        right = n - 1;
        left = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;

            if (matrix[temp][mid] > target) {
                right = mid - 1;
            } else if (matrix[temp][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean searchMatrixII(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int left=0,right=m*n-1,mid=0;
        while(left<=right){
            mid=(right-left)/2+left;
            if(matrix[mid/n][mid%n]>target){
                right=mid-1;
            }else if(matrix[mid/n][mid%n]<target){
                left=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2dMatrix searchA2dMatrix=new SearchA2dMatrix();
        boolean result=searchA2dMatrix.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}},10);
        System.out.println(result);
    }
}
