import java.util.*;

public class MinimumGeneticMutation {
    /*
     * 题 目：最小基因变化
     * 链 接: https://leetcode-cn.com/problems/minimum-genetic-mutation
     * 描 述：一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
     *      假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
     *      现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始
     *      基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
     */
    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) return -1;
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) return -1;
        set.remove(start);
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(start);
        Queue<String> q = new LinkedList<>();
        q.add(start);
        int step = 0;
        char[] base = new char[]{'A', 'C', 'G', 'T'};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                String current = q.poll();
                char[] array = current.toCharArray();
                for (int k = 0; k < array.length; ++k) {
                    char org = array[k];
                    for (char c : base) {
                        if (array[k] == c) continue;
                        array[k] = c;
                        String newStr = String.valueOf(array);
                        if (newStr.equals(end)) return step + 1;
                        if (visitedSet.contains(newStr)) continue;
                        if (set.contains(newStr)) {
                            q.add(newStr);
                            visitedSet.add(newStr);
                        }
                    }
                    array[k] = org;
                }

            }
            ++step;
        }
        return -1;
    }

    public static void main(String[] args) {
        Test test = new Test();
        String[] bank = new String[]{"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};
        int result = test.minMutation("AACCTTGG", "AATTCCGG", bank);
        System.out.println(result);
    }

}
