public class LongestCommonSubsequence {
    /*
     * 题 目：给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
     * 链 接: https://leetcode-cn.com/problems/longest-common-subsequence/
     * 描 述：一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     *       例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
     *       若这两个字符串没有公共子序列，则返回 0。
     */
    //时间复杂度O(m*n) 空间复杂度O(n)
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(),n=text2.length();
        int[][] table=new int[m+1][n+1];
        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    table[i][j]=table[i-1][j-1]+1;
                }else{
                    table[i][j]=Math.max(table[i-1][j-2],table[i-2][j-1]);
                }
            }
        }
        return table[m][n];
    }
}
