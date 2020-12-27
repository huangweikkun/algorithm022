import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author jacken
 * @date 2020/12/26 10:23 PM
 */
public class TopKFrequent {

  // 计数+排序 (nlogn)
  // 计数+使用堆 (nlogk)
  // 计数加快排 (n)
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      Integer count = map.getOrDefault(nums[i],  0);
      map.put(nums[i], ++count);
    }

    PriorityQueue<Integer>  priorityQueue = new PriorityQueue<>(Comparator.comparingInt(map::get));
    for (Integer key : map.keySet()) {
      if (priorityQueue.size() < k) {
        priorityQueue.offer(key);
      } else {
        if (map.get(key) > map.get(priorityQueue.peek())) {
          priorityQueue.poll();
          priorityQueue.offer(key);
        }
      }
    }

    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = priorityQueue.poll();
    }

    return result;
  }

}
