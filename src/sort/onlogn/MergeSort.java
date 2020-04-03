package sort.onlogn;

/**
 * @author Ikaros
 * @date 2020/3/22 23:16
 */
public class MergeSort {
  public static void sort(Comparable[] array) {
    mergeSort(array, 0, array.length - 1);
  }

  /**
   * 递归使用归并排，对array[l, r]的范围进行排序
   *
   * @param array
   * @param l
   * @param r
   */
  private static void mergeSort(Comparable[] array, int l, int r) {
    if (l >= r) {
      return;
    }
    int mid = (r - l) / 2 + l;
    mergeSort(array, l, mid);
    mergeSort(array, mid + 1, r);
    merge(array, l, mid, r);
  }

  private static void merge(Comparable[] array, int l, int mid, int r) {
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
