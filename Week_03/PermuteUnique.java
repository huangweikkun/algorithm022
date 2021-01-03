import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacken
 * @date 2021/1/1 11:12 AM
 */
public class PermuteUnique {

  public List<List<Integer>> permuteUnique(int[] nums) {
    // 排序
    Arrays.sort(nums);
    boolean[] visited = new boolean[nums.length];
    List<List<Integer>> resultList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    permute(nums, resultList, list, 0, visited);
    return resultList;
  }

  public void permute(int[] nums, List<List<Integer>> resultList, List<Integer> list, int index, boolean[] visited) {
    if (index == nums.length) {
      resultList.add(new ArrayList(list));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (!visited[i] && nums[i] != nums[index]) {
        list.add(nums[index]);
        visited[index] = true;
        permute(nums, resultList, list, index + 1, visited);
        list.remove(list.size() - 1);
        visited[index] = false;
      }
    }
  }

}
