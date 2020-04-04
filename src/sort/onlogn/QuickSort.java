package sort.onlogn;

/**
 * @author Ikaros
 * @date 2020/4/4 8:36
 */
public class QuickSort {
    public static void sort(Comparable[] array, Integer l, Integer r) {
        if (l >= r) {
            return;
        }
        int p = partition(array, l, r);
        sort(array, l, p - 1);
        sort(array, p + 1, r);
    }
    
    private static int partition(Comparable[] array, Integer l, Integer r) {
        Comparable temp = array[l];
        // array[l + 1, j] < temp
        // array[j + 1, i - 1] > temp
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (array[i].compareTo(temp) < 0) {
                swap(array, i, ++j);
            }
        }
        swap(array, l, j);
        return j;
        
    }
    
    private static void swap(Comparable[] array, int i, int j) {
        assert i >= 0 && j >= 0 && array != null && i < array.length && j < array.length;
        if (i == j) {
            return;
        }
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
