/**
 * @author jacken
 * @date 2021/1/9 3:51 PM
 */
public class FindUnsortedInRotatedArray {

  // 无序点的判断条件为num[i-1] > nums[i] || nums[i] > nums[i+1]
  // 当切分之后，
  // 1. nums[left] >= nums[mid] 无序点位于left - mid区间
  // 2. nums[right] < nums[mid] 无序点位于mid + 1 - right区间;
  // O(logn)
  private int findUnsortedInRotatedArray(int[] nums) {
    if (nums == null) {
      return -1;
    }

    if (nums.length == 1) {
      return nums[0];
    }

    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
        return nums[mid];
      }
      if (mid + 1 < nums.length && nums[mid + 1] < nums[mid]) {
        return nums[mid + 1];
      }

      if (nums[left] >= nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    String str = "";
    str.toCharArray();

    return nums[0];
  }

}
