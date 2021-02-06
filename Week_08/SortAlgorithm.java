import java.util.Arrays;

/**
 * @author jacken
 * @date 2021/2/6 12:33 PM
 */
public class SortAlgorithm {

  /**
   * 选择排序 O(n^2)
   * 每次循环从未排序数组中选择最小元素
   *
   * @param nums
   */
  public void selectionSort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < nums.length; j++) {
        minIndex = nums[minIndex] > nums[j] ? j : minIndex;
      }
      int temp = nums[i];
      nums[i] = nums[minIndex];
      nums[minIndex] = temp;
    }
  }

  public static void main(String[] args) {
    SortAlgorithm sortAlgorithm = new SortAlgorithm();
    int[] nums = new int[]{4,2,2,1};
    sortAlgorithm.quickSort(nums);
    System.out.println(Arrays.toString(nums));
  }

  /**
   * 插入排序 O(n^2)
   * 将未排序元素插入到排序的元素数组中
   * @param nums
   */
  public void insertionSort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      int j = i - 1;
      int temp = nums[i];
      for (; j >= 0; j--) {
        if (temp > nums[j]) {
          break;
        }
        nums[j + 1] = nums[j];
      }
      nums[j + 1] = temp;
    }
  }

  /**
   * 冒泡排序 O(n^2)
   *
   * @param nums
   */
  public void bubbleSort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = 0; j < nums.length - i - 1; j++) {
        if (nums[j] > nums[j+1]) {
          int temp = nums[j];
          nums[j] = nums[j+1];
          nums[j+1] = temp;
        }
      }
    }
  }

  /**
   * 归并排序 O(nlogn)
   * 分为两部分，每个部分分别进行排序，然后将排序好的部分合并
   * @param nums
   */
  public void mergeSort(int[] nums) {
    mergeSort(nums, 0, nums.length -1);
  }

  private void mergeSort(int[] nums, int low, int high) {
    if (low >= high) {
      return;
    }

    int mid = low + ((high - low) >> 1);
    mergeSort(nums, low, mid);
    mergeSort(nums, mid + 1, high);

    merge(nums, low, mid, high);
  }

  private void merge(int[] nums, int low, int mid, int high) {
    int[] temp = new int[high - low + 1];
    int i = low;
    int j = mid + 1;

    int index = 0;
    while (i <= mid && j <= high) {
      temp[index++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
    }
    while (i <= mid) temp[index++] = nums[i++];
    while (j <= high) temp[index++] = nums[j++];

    for (int k = 0; k < temp.length; k++) {
      nums[low + k] = temp[k];
    }
  }


  /**
   * 快速排序 O(nlogn)
   * 先对数组选定元素进行分割，然后将分割后的部分在进行同样的操作，直到分割后的数组长度为1
   * @param nums
   */
  public void quickSort(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
  }

  private void quickSort(int[] nums, int low, int high) {
    if (low >= high) {
      return;
    }

    int pivot = partition(nums, low, high);
    quickSort(nums, low, pivot - 1);
    quickSort(nums, pivot + 1, high);
  }

  private int partition(int[] nums, int low, int high) {
    int split = high;
    int i = low;
    int j = high;
    while (i < j) {
      while (i < j && nums[i] <= nums[split]) i++;
      while (i < j && nums[j] > nums[split]) j--;

      if (i < j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    }

    int temp = nums[i];
    nums[i] = nums[split];
    nums[split] = temp;
    return i;
  }

  /**
   * 堆排序 O(nlogn)
   *
   * @param nums
   */
  public void heapSort(int[] nums) {

  }
}
