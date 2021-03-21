package bfs;

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
        if (!wordSet.contains(endWord)) return 0;
        wordSet.remove(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String currentWord = queue.poll();
                char[] chars = currentWord.toCharArray();
                for (int j = 0; j < chars.length; ++j) {
                    char old = chars[j];
                    for (char k = 'a'; k <= 'z'; ++k) {
                        if (chars[j] == k) continue;
                        chars[j] = k;
                        String newWord = String.valueOf(chars);
                        if (newWord.equals(endWord)) return count + 1;
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    chars[j] = old;
                }
            }
            count++;
        }

        return 0;
    }


    public int ladderLengthII(String beginWord, String endWord, Set<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        int count = 1;
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)) {
                            return count + 1;
                        }
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                    }
                    chs[i] = old;
                }
            }
            beginSet = temp;
            count++;
        }
        return 0;
    }


}
