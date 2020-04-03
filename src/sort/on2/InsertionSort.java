package sort.on2;

/**
 * 前面部分为排好序，后面部分未排序 每次未排序部分的第一个一直往前交换直到合适的位置
 *
 * @author Ikaros
 * @date 2020/3/22 10:41
 */
public class InsertionSort {
  public static void sort(Comparable[] array) {

    // 表示未排序
    for (int i = 1; i < array.length; i++) {
      Comparable temp = array[i];
      int j;
      // 遍历前序，且当前数小于前一个数，则将当前数赋值为前一个数
      for (j = i; j > 0 && temp.compareTo(array[j - 1]) < 0; j--) {
        array[j] = array[j - 1];
      }
      array[j] = temp;
    }
  }
}
