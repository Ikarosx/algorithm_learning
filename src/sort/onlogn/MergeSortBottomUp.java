package sort.onlogn;

/**
 * @author Ikaros
 * @date 2020/4/3 20:08
 */
public class MergeSortBottomUp {
    public static void sort(Comparable[] array, Integer l, Integer r) {
        for (int size = 1; size <= (r - l) + 1; size += size) {
            // i + size确保有第二部分
            for (int i = l; i + size <= r; i += size + size) {
                // 对 arr[i...i+size-1]和arr[i+size...i+2*size-1]进行归并
                // Math.min解决第二部分可能不足2*size大小
                if (array[i + size - 1].compareTo(array[i + size]) > 0) {
                    MergeSort.merge(array, i, i + size - 1, Math.min(i + size + size - 1, r));
                }
            }
        }
    }
}
