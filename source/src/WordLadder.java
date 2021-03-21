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


    public int ladderLengthII(String beginWord, String endWord, List<String> wordList) {
        Set<String> allWordSet = new HashSet<>(wordList);
        if(!allWordSet.contains(endWord)) return 0;
        wordList.add(beginWord);
        // 从两端 BFS 遍历要用的队列
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        // 两端已经遍历过的节点
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        queue1.offer(beginWord);
        queue2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);
        int count = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue1.size() > queue2.size()) {
                Queue<String> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                Set<String> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size1 = queue1.size();
            while (size1-- > 0) {
                String s = queue1.poll();
                char[] chars = s.toCharArray();
                for (int j = 0; j < s.length(); ++j) {
                    // 保存第j位的原始字符
                    char c0 = chars[j];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[j] = c;
                        String newString = new String(chars);
                        // 已经访问过了，跳过
                        if (visited1.contains(newString)) {
                            continue;
                        }
                        // 两端遍历相遇，结束遍历，返回 count
                        if (visited2.contains(newString)) {
                            return count + 1;
                        }
                        // 如果单词在列表中存在，将其添加到队列，并标记为已访问
                        if (allWordSet.contains(newString)) {
                            queue1.offer(newString);
                            visited1.add(newString);
                        }
                    }
                    // 恢复第j位的原始字符
                    chars[j] = c0;
                }
            }
        }
        return 0;
    }




}
