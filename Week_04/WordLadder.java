import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacken
 * @date 2021/1/9 6:02 PM
 */
public class WordLadder {

  // DFS 每个变换单词与worldList中单词比较，相差为一位时则进行转换，并记录当前已变换的单词，此方法超时
  // BFS，从单词的第一位到最后一位逐一替换‘a’-'z'
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);

    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    queue.add(beginWord);
    visited.add(beginWord);
    int step = 1;
    while (!queue.isEmpty()) {
      int currentSize = queue.size();
      for (int size = 0; size < currentSize; size++) {
        String str = queue.poll();
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
          char original = charArr[i];
          for (char k = 'a'; k <= 'z'; k++) {
            if (original == k) {
              continue;
            }

            charArr[i] = k;
            String newStr = String.valueOf(charArr);
            if (wordSet.contains(newStr)) {
              if (newStr.equals(endWord)) {
                return step + 1;
              }

              if (visited.contains(newStr)) {
                continue;
              }

              queue.add(newStr);
              visited.add(newStr);
            }
          }
          charArr[i] = original;
        }
      }
      step++;
    }

    return 0;
  }

//  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//    boolean[] visited = new boolean[wordList.size()];
//    if (!wordList.contains(endWord)) {
//      return 0;
//    }
//
//    changeWord(beginWord, endWord, wordList, visited, 0);
//    return minTimes == Integer.MAX_VALUE ? 0 : minTimes;
//  }
//
//  void changeWord(String beginWord, String endWord, List<String> wordList, boolean[] visited, int times) {
//    if (beginWord.equals(endWord)) {
//      minTimes = Math.min(minTimes, times);
//      return;
//    }
//
//    for (int i = 0; i < wordList.size(); i++) {
//      // 计算两个单词相差次数
//      String validStr = wordList.get(i);
//      int diff = 0;
//      for (int j = 0; j < beginWord.length(); j++) {
//        if (beginWord.charAt(j) != validStr.charAt(j)) {
//          diff++;
//        }
//      }
//
//      if (diff == 1) {
//        if (visited[i]) {
//          continue;
//        }
//
//        visited[i] = true;
//        changeWord(validStr, endWord, wordList, visited, times + 1);
//      }
//    }
//  }

}
