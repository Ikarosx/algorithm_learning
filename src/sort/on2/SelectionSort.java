package sort.on2;

import sort.helper.SortTestHelper;

/**
 * 每次从未排序的数据中找到最小的，然后和未排序的首位交换，直到末尾
 *
 * @author Ikaros
 * @date 2020/3/21 15:51
 */
public class SelectionSort {
  public static void sort(Comparable[] arr) {
    assert arr != null;
    int minIndex;
    for (int i = 0; i < arr.length; i++) {
      minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j].compareTo(arr[minIndex]) <= 0) {
          minIndex = j;
        }
      }
      SortTestHelper.swap(arr, minIndex, i);
    }
  }
}
