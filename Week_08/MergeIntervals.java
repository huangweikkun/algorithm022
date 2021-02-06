import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacken
 * @date 2021/2/6 6:09 PM
 */
public class MergeIntervals {

  public int[][] merge(int[][] intervals) {
    // 根据区间的左区间进行排序
    Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

    // 遍历排序过的区间，判断是否有重合，重合的进行合并
    List<int[]> result = new ArrayList<>();
    int[] interval = intervals[0];
    for (int i = 0; i < intervals.length - 1; i++) {
      if (interval[1] < intervals[i+1][0]) {
        result.add(interval);
        interval = intervals[i+1];
      } else {
        interval[1] = Math.max(interval[1], intervals[i+1][1]);
      }
    }

    result.add(interval);
    return result.toArray(new int[0][]);
  }

}
