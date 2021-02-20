import javax.swing.text.html.parser.Entity;
import java.util.*;

public class GroupAnagrams {
    /*
     * 题 目：字母异位词分组
     * 链 接：https://leetcode-cn.com/problems/group-anagrams/
     * 描 述：给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;++i){
            char [] array=strs[i].toCharArray();
            Arrays.sort(array);
            String str= String.copyValueOf(array);
            if(map.containsKey(str)){
                List<String>list=map.get(str);
                list.add(strs[i]);
            }else{
                map.put(str,new ArrayList<>(Arrays.asList(strs[i])));
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[]strs=new String[]{"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams groupAnagrams=new GroupAnagrams();
        groupAnagrams.groupAnagrams(strs);
        System.out.println();
    }


}
