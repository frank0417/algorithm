import java.util.*;

public class Test {

    public static void main(String[] args) {

        /*beginWord = "hit",
                endWord = "cog",
                wordList = ["hot","dot","dog","lot","log","cog"]*/


/*[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]*/


        Test test = new Test();
        List<List<String>> result = test.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(result);
    }


    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] table = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++m) {
            for (int j = 1; j <= n; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
                }

            }
        }
        return table[m][n];
    }


    public boolean isValid(String s) {
        if (s.length() < 2) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            if (c == '[') stack.push(']');
            if (c == '{') stack.push('}');
            if (c == ')' && stack.pop() != ')') return false;
            if (c == ']' && stack.pop() != ']') return false;
            if (c == '}' && stack.pop() != '}') return false;
        }
        return true;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (wordList == null) return result;
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return result;

        Set<String> visitedSet = new HashSet<>();
        wordSet.remove(beginWord);
        visitedSet.add(beginWord);
        Queue<String> queue = new LinkedList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                String currentWord = queue.poll();
                List<String> levelList = new ArrayList<>();
                changeWord(currentWord, endWord, queue, wordSet, visitedSet, result);
            }

        }

        return result;
    }

    private void changeWord(String currentWord, String endWord, Queue queue, Set<String> wordSet, Set<String> visitedSet, List<List<String>> result) {
        char[] orgWordArray = currentWord.toCharArray();
        for (int i = 0; i < orgWordArray.length; ++i) {
            char orgChar = orgWordArray[i];
            for (char k = 'a'; k < 'z'; ++k) {
                if (orgWordArray[i] == k) continue;
                orgWordArray[i] = k;
                String changeWord = String.valueOf(orgWordArray);
                if (changeWord.equals(endWord)) return;
                if (visitedSet.contains(changeWord)) continue;
                if (wordSet.contains(changeWord)) {
                    queue.add(changeWord);
                    visitedSet.add(changeWord);
                }
            }
        }
    }


    public boolean lemonadeChange(int[] bills) {
        int len = 0;
        if (bills == null || (len = bills.length) == 0) return true;
        int m5 = 0, m10 = 0;
        for (int i = 0; i < len; ++i) {
            if (bills[i] == 5) {
                m5++;
            } else if (bills[i] == 10) {
                m10++;
                m5--;
            } else if (bills[i] == 20) {
                if (m10 > 0) {
                    m10--;
                    m5--;
                } else {
                    m5 = m5 - 3;
                }
            }

            if (m5 < 0) return false;
        }
        return true;
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, mid;
        return nums[right - left / 2 + left];
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int path = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String currentWord = queue.poll();
                if (changeWordEveryChar(currentWord, endWord, queue, wordSet, visited)) {
                    return path + 1;
                }
            }
            path++;
        }
        return 0;
    }

    private boolean changeWordEveryChar(String currentWord, String endWord, Queue queue, Set<String> wordSet, Set<String> visited) {
        char[] wordArray = currentWord.toCharArray();
        for (int i = 0; i < wordArray.length; ++i) {
            char org = wordArray[i];
            for (char k = 'a'; k <= 'z'; ++k) {
                wordArray[i] = k;
                String newWord = String.valueOf(wordArray);
                if (newWord.equals(endWord)) {
                    return true;
                }
                if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                    queue.add(newWord);
                    visited.add(newWord);
                }
            }
            wordArray[i] = org;
        }
        return false;
    }

    //[2,1,5,6,2,3] 10
    public int largestRectangleArea(int[] heights) {
        int len = 0;
        if (heights == null || (len = heights.length) == 0) return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        ;
        stack.push(-1);
        for (int i = 0; i < len; ++i) {
            if (stack.peek() > -1 && heights[i] < heights[stack.peek()]) {
                while (stack.peek() > -1 && heights[i] < heights[stack.peek()]) {
                    maxArea = Math.max(maxArea, heights[i] * (i - stack.peek() - 1));
                }
            }
            stack.push(i);
        }

        while (stack.peek() > -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (len - stack.peek() - 1));
        }

        return maxArea;
    }

    public int trap(int[] height) {
        int len = 0;
        if (height == null || (len = height.length) == 0) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; ++i) {
            int d = 0, h = 0;
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int tem = stack.pop();
                if (stack.isEmpty()) break;
                h = Math.min(height[stack.peek()], height[i]) - height[tem];
                d = i - stack.peek() - 1;
                res += h * d;
            }
            stack.push(i);
        }
        return res;
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) - 1 < 0) return false;
        }

        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int len = 0;
        if (strs == null || (len = strs.length) == 0) return Collections.emptyList();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < len; ++i) {
            char[] strArray = strs[i].toCharArray();
            Arrays.sort(strArray);
            String newStr = String.copyValueOf(strArray);
            if (map.containsKey(newStr)) {
                List<String> list = map.get(newStr);
                list.add(strs[i]);
            } else {
                map.put(newStr, new ArrayList<>(Arrays.asList(strs[i])));
            }
        }

        return new ArrayList<>(map.values());
    }

    //"A", "C", "G", "T"
    public int minMutation(String start, String end, String[] bank) {
        char[] mu = new char[]{'A', 'C', 'G', 'T'};
        Set<String> muSet = new HashSet<>(Arrays.asList(bank));
        if (!muSet.contains(end)) return -1;
        Set<String> visited = new HashSet<>();
        visited.add(start);
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String str = queue.poll();
                char[] arrays = str.toCharArray();
                for (int j = 0; j < arrays.length; ++j) {
                    char old = arrays[j];
                    for (char c : mu) {
                        if (old == c) continue;
                        arrays[j] = c;
                        String newStr = String.valueOf(arrays);
                        if (newStr.equals(end)) return len + 1;
                        if (!visited.contains(newStr) && muSet.contains(newStr)) {
                            visited.add(newStr);
                            queue.add(newStr);
                        }
                    }
                    arrays[j] = old;
                }
            }
            len++;
        }
        return -1;
    }


}




