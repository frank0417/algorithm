package array;

public class RelativeSortArray {
    /*
     * 题 目：数组的相对排序
     * 链 接: https://leetcode-cn.com/problems/relative-sort-array/
     * 描 述：给你两个数组，arr1 和 arr2，
     *      arr2 中的元素各不相同
     *      arr2 中的每个元素都出现在 arr1 中
     *      对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int arry1len = arr1.length;
        int arry2len=arr2.length;
        int[] map = new int[1001];
        int k=0;
        for (int i = 0; i < arry1len; ++i) map[arr1[i]]++;
        for(int i=0;i<arry2len;++i){
            while(map[arr2[i]]-- >0){
                arr1[k++]=arr2[i];
            }
        }

        for(int i=0;i<1001;++i){
            while(map[i]-- >0) {
                arr1[k++] = map[i];
            }
        }

        return arr1;
    }

    public static void main(String[] args) {
        RelativeSortArray re = new RelativeSortArray();
        re.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6});
    }

}
