/**
 * @author jacken
 * @date 2021/1/9 12:46 PM
 */
public class SearchInRotatedSortedArray {

  // 遍历 On
  // 二分查找 Ologn
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      // 判断分割点是左边有序还是右边有序
      // 左边有序,>=是因为当数组长度为2时，如果是>,中点是向下取整，则查到第一个数是直接返回的，但是查到第二个数时会导致右边界向左推移，导致返回错误答案，如果是>=则是左边界右移，则可以正常返回。
      if (nums[mid] >= nums[left]) {
        if (nums[mid] > target && nums[left] <= target) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] < target && nums[right] >= target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return -1;
  }
}
