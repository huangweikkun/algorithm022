import static java.lang.Math.pow;

/**
 * @author jacken
 * @date 2021/2/19 11:02 PM
 */
public class NumDecodings {

  // dp[i] = char[i] != '0' ? dp[i] : 0;
  // dp[i] = (int)(char[i] + char[i-1]) >= 10 && <= 26 ?  dp[i] + dp[i-2] : dp[i]
  public int numDecodings(String s) {
    if (s.charAt(0) == '0') {
      return 0;
    }

    int length = s.length();
    int[] dp = new int[length + 1];
    char[] charArr = s.toCharArray();
    // 0个字符编码方式只有一种
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 1; i < length; i++) {
      if (charArr[i] != '0') {
        dp[i + 1] = dp[i];
      }

      int num = 10 * (charArr[i - 1] - '0') + (charArr[i] - '0');
      if (num >= 10 && num <= 26) {
        dp[i + 1] += dp[i - 1];
      }
    }

    return dp[length];
  }

}
