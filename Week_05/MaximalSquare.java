/**
 * @author jacken
 * @date 2021/1/17 9:33 PM
 */
public class MaximalSquare {

  // dp O(mn)
  public int maximalSquare(char[][] matrix) {
    int maxSide = 0;
    int[][] dp = new int[matrix.length][matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == '0') {
          continue;
        }

        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
        }

        maxSide = Math.max(maxSide, dp[i][j]);
      }
    }

    return maxSide * maxSide;
  }
}
