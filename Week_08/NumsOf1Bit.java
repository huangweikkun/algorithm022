/**
 * @author jacken
 * @date 2021/2/6 4:28 PM
 */
public class NumsOf1Bit {

  // O(1)
  // 每一位数字与1做运算，结果不等于0表示该位为1
  public int hammingWeight(int n) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      int result = n & 1 << i;
      if (result != 0) count ++;
    }
    return count;
  }

  // O(1)
  // 将 n 和 n - 1做与运算，会把最后一个 1 的位变成 0，知道n==0停止计数
  public int hammingWeight2(int n) {
    int count = 0;
    while (n != 0) {
      n &= (n-1);
      count++;
    }
    return count;
  }

}
