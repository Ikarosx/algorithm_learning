package sort.question.逆序对;

import java.util.Arrays;

/**
 * @author Ikaros
 * @date 2020/4/4 12:10
 */
public class InversePair {
    static int count = 0;
    
    public static int countInversePair(Integer[] array, int l, int r) {
        mergeSort(array, l, r);
        return count;
    }
    
    private static void mergeSort(Integer[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (r - l) / 2 + l;
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);
        if (array[mid] > array[mid + 1]) {
            merge(array, l, mid, r);
        }
    }
    
    private static void merge(Integer[] array, int l, int mid, int r) {
        int[] ints = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            ints[i - l] = array[i];
        }
        int m = 0;
        int n = mid - l + 1;
        for (int i = l; i <= r; i++) {
            if (m > mid - l) {
                array[i] = ints[n++];
            } else if (n > r - l) {
                array[i] = ints[m++];
            } else if (ints[m] <= ints[n]) {
                array[i] = ints[m++];
            } else {
                array[i] = ints[n++];
                count += mid - l - m + 1;
            }
        }
    }
}
