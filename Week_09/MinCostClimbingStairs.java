/**
 * @author jacken
 * @date 2021/2/20 9:59 PM
 */
public class MinCostClimbingStairs {

  // dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
  // O(n)
  public int minCostClimbingStairs(int[] cost) {
    int pre = 0;
    int cur = 0;

    for (int i = 2; i < cost.length + 1; i++) {
      int temp = cur;
      cur = Math.min(pre + cost[i-2], cur + cost[i-1]);
      pre = temp;
    }

    return cur;
  }

}
