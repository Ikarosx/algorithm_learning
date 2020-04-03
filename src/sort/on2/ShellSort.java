package sort.on2;

/**
 * @author Ikaros
 * @date 2020/3/22 18:17
 */
public class ShellSort {
  public static void sort(Comparable[] array) {
    // 增量gap，并逐步缩小增量
    for (int gap = array.length / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < array.length; i++) {
        int j = i;
        Comparable temp = array[j];
        while (j - gap >= 0 && temp.compareTo(array[j - gap]) < 0) {
          array[j] = array[j - gap];
          j -= gap;
        }
        array[j] = temp;
      }
    }
  }
}
