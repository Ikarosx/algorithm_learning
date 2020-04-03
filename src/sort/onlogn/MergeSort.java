package sort.onlogn;

import sort.on2.InsertionSort;

/**
 * @author Ikaros
 * @date 2020/3/22 23:16
 */
public class MergeSort {
  public static void sort(Comparable[] array, Integer l, Integer r) {
    mergeSort(array, l, r);
  }

  /**
   * 递归使用归并排序，对array[l, r]的范围进行排序
   *
   * @param array
   * @param l
   * @param r
   */
  private static void mergeSort(Comparable[] array, int l, int r) {
    // 优化：在数量级比较小的时候采用插入排序
    if (r - l <= 15) {
      InsertionSort.sort(array, l, r);
      return;
    }

    int mid = (r - l) / 2 + l;
    mergeSort(array, l, mid);
    mergeSort(array, mid + 1, r);
    // 优化：提前返回
    if (array[mid].compareTo(array[mid + 1]) > 0) {
      merge(array, l, mid, r);
    }
  }

  public static void merge(Comparable[] array, int l, int mid, int r) {
    Comparable[] temp = new Comparable[r - l + 1];
    for (int i = l; i <= r; i++) {
      temp[i - l] = array[i];
    }
    int i = l;
    int j = mid + 1;
    for (int k = l; k <= r; k++) {
      if (i > mid) {
        array[k] = temp[j++ - l];
      } else if (j > r) {
        array[k] = temp[i++ - l];
      } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
        array[k] = temp[i++ - l];
      } else {
        array[k] = temp[j++ - l];
      }
    }
  }
}
