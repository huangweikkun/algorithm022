/**
 * @author jacken
 * @date 2021/2/21 5:04 PM
 */
public class EditDistance {

  // O(mn)
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();

    int[][] dp = new int[m+1][n+1];

    // 初始化状态word1字符串到word2空串的最小编辑距离为删除word1的每个字符
    for (int i = 1; i <= m; i++) {
      dp[i][0] = i;
    }
    // 初始化状态word1空串到word2字符串的最小编辑距离为插入word2的每个字符
    for (int i = 1; i <= n; i++) {
      dp[0][i] = i;
    }

    // 1. word1[i] == word2[j]  不用进行操作，则dp[i][j]=dp[i-1][j-1];
    // 2. word1[i] != word2[j] 进行插入dp[i][j-1] + 1，删除dp[i-1][j] + 1或者替换操作dp[i-1][j-1]
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (word1.charAt(i-1) == word2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1];
        } else {
          int min = Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1);
          dp[i][j] = Math.min(min, dp[i-1][j-1] + 1);
        }
      }
    }

    return dp[m][n];
  }

}
