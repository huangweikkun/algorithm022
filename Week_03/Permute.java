import java.util.ArrayList;
import java.util.List;

/**
 * @author jacken
 * @date 2021/1/1 10:34 AM
 */
public class Permute {

  // 递归 O(n!)
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      list.add(curList);
      return list;
    }

    boolean[] visited = new boolean[nums.length];
    recur(list, curList, nums, nums.length, visited);
    return list;
  }

  private void recur(List<List<Integer>> list, List<Integer> curList, int[] nums, int n, boolean[] visited) {
    if (n == 0) {
      list.add(new ArrayList<>(curList));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (!visited[i]) {
        curList.add(nums[i]);
        visited[i] = true;
        recur(list, curList, nums, n -1, visited);
        curList.remove(curList.size() - 1);
        visited[i] = false;
      }
    }
  }
}
