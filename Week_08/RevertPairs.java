import java.util.Arrays;

/**
 * @author jacken
 * @date 2021/2/6 9:11 PM
 */
public class RevertPairs {

  private int count;

  // 1. 逐个循环O(n^2)
  // 2. 归并排序
  public int reversePairs(int[] nums) {
    count = 0;
    mergeSort(nums, 0, nums.length - 1);
    return count;
  }

  private void mergeSort(int[] nums, int low, int high) {
    if (low >= high) {
      return;
    }

    int mid = low + (high - low) / 2;
    mergeSort(nums, low, mid);
    mergeSort(nums, mid + 1, high);

    int i = low;
    int j = mid + 1;
    while (i <= mid && j <= high) {
      if ((long)nums[i] > 2 * (long)nums[j]) {
        j++;
        count += (mid - i + 1);
      } else {
        i++;
      }
    }

    // 排序
    Arrays.sort(nums, low, high + 1);
  }

}
