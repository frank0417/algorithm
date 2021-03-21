public class Tihuankonggelcof {
    /*
     * 题 目：替换空格
     * 链 接: https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
     * 描 述：请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     */
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return s;
        char[] arrays = new char[s.length() * 3];
        int k = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                arrays[k++] = s.charAt(i);
            } else {
                arrays[k++] = '%';
                arrays[k++] = '2';
                arrays[k++] = '0';
            }
        }
        return new String(arrays,0,k);
    }


}
