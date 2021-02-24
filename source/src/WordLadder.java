import java.util.*;

public class WordLadder {
    /*
     * 题 目：单词接龙
     * 链 接: https://leetcode-cn.com/problems/word-ladder
     * 描 述：字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
     *       序列中第一个单词是 beginWord 。
     *       序列中最后一个单词是 endWord 。
     *       每次转换只能改变一个字母。
     *       转换过程中的中间单词必须是字典 wordList 中的单词。
     *       给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的
     *       最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
     */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visitedSet = new HashSet<>();
        if (!wordSet.contains(endWord)) return 0;
        wordSet.add(endWord);
        visitedSet.add(beginWord);
        Queue<String> q = new LinkedList();
        q.add(beginWord);
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                String currentWord = q.poll();
                if (changeWord(q, currentWord, endWord, visitedSet, wordSet)) {
                    return step + 1;
                }
            }
            ++step;
        }
        return 0;
    }

    private boolean changeWord(Queue<String> q, String currentWord, String endWord, Set<String> visitedSet, Set<String> wordSet) {
        char[] orgWord = currentWord.toCharArray();
        for (int i = 0; i < orgWord.length; ++i) {
            char orgChar = orgWord[i];
            for (char k = 'a'; k < 'z'; ++k) {
                if (orgWord[i] == k) continue;
                orgWord[i] = k;
                String changeWord = String.valueOf(orgWord);
                if (changeWord.equals(endWord)) return true;
                if (wordSet.contains(changeWord)) {
                    visitedSet.add(changeWord);
                    q.add(changeWord);
                }

            }
            orgWord[i] = orgChar;
        }
        return false;
    }
}
