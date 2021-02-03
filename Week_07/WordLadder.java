package bfs;

import java.util.*;

/**
 * @author huangweikun
 * @date 2021/2/3 10:19
 */
public class WordLadder {

    // 双向dfs,从头尾同时进行bfs搜索
    public int ladderLengthDFS2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);
        int step = 1;

        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 从长度较小的集合进行bfs搜索，减小拓展的数量
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                if (changeLetter(word, wordSet, visited, endVisited, nextLevelVisited)) {
                    return ++step;
                }
            }
            beginVisited = nextLevelVisited;
            step++;
        }

        return 0;
    }

    public boolean changeLetter(String word, Set<String> wordSet, Set<String> visited, Set<String> endVisited, Set<String> nextLevelVisited) {
        char[] wordArray = word.toCharArray();
        for (int j = 0; j < wordArray.length; j++) {
            char pre = wordArray[j];
            for (char c = 'a'; c <= 'z'; c++) {
                if (pre == c) {
                    continue;
                }

                wordArray[j] = c;
                String next = String.valueOf(wordArray);
                if (endVisited.contains(next)) {
                    return true;
                }

                if (wordSet.contains(next) && !visited.contains(next)) {
                    visited.add(next);
                    nextLevelVisited.add(next);
                }
            }
            wordArray[j] = pre;
        }

        return false;
    }

    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        Set<String> visited = new HashSet();
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] wordArray = word.toCharArray();
                for (int j = 0; j < wordArray.length; j++) {
                    char pre = wordArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String next = new String(wordArray);
                        if (next.equals(endWord)) {
                            return ++step;
                        }

                        if (wordSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                    wordArray[j] = pre;
                }

            }
            step++;
        }

        return 0;
    }

}
