import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author jacken
 * @date 2020/12/26 8:51 PM
 */
public class NthUglyNumber {

  // 优先队列加set过滤，排序计算，并过滤重复计算的丑数
  public int nthUglyNumber(int n) {
    if (n == 0) {
      return 0;
    }

    PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
    long[] nums = new long[]{2,3,5};

    long uglyNum = 1;
    priorityQueue.offer(1L);
    Set<Long> set = new HashSet<>();
    for(int i = 1; i <= n; i++) {
      uglyNum = priorityQueue.poll();
      for (int j = 0; j < nums.length; j++) {
        long newUglyNum = uglyNum * nums[j];
        if (!set.contains(newUglyNum)) {
          priorityQueue.offer(newUglyNum);
          set.add(newUglyNum);
        }
      }
    }
    return (int)uglyNum;
  }

}
