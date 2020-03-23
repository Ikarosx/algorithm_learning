package sort;

import sort.helper.SortTestHelper;

/**
 * 思路：重复遍历，每次查看相邻的两个，如果后面的数小于前面则交换，直到不需要交换
 *
 * @author Ikaros
 * @date 2020/3/22 17:03
 */
public class BubbleSort {
  public static void sort(Comparable[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      boolean flag = true;
      for (int i1 = 0; i1 < array.length - 1 - i; i1++) {
        if (array[i1].compareTo(array[i1 + 1]) > 0) {
          SortTestHelper.swap(array, i1, i1 + 1);
          flag = false;
        }
      }
      if (flag) {
        break;
      }
    }
  }
}
