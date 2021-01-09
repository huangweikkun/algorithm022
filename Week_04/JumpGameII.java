/**
 * @author jacken
 * @date 2021/1/9 10:43 PM
 */
public class JumpGameII {

  // 每次都从当前位置寻找下一个从i起步能跳的最远的位置 On
  public int jump(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }

    int step = 1;
    int mostFar = nums[0] + 0;
    int index = 0;
    while (mostFar < nums.length - 1) {
      int curMostFar = mostFar;
      for (int i = index + 1; i <= curMostFar; i++) {
        // 下一个位置中寻找能跳跃到最远的位置下标
        if (nums[i] + i > mostFar) {
          mostFar = nums[i] + i;
          index = i;
        }
      }
      step++;
    }

    return step;
  }
}
