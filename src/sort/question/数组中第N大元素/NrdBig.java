package sort.question.数组中第N大元素;

import java.util.Random;

import static sort.helper.SortTestHelper.swap;

/**
 * @author Ikaros
 * @date 2020/4/4 13:57
 */
public class NrdBig {
    public static Comparable nrdBig(Comparable[] array, Integer l, Integer r, int k) {
        int p = partition(array, l, r);
        if (p == k - 1) {
            return array[p];
        } else if (p > k - 1) {
            return nrdBig(array, l, p - 1, k);
        } else {
            return nrdBig(array, p + 1, r, k);
        }
    }
    
    private static int partition(Comparable[] array, Integer l, Integer r) {
        swap(array, l, Math.abs(new Random().nextInt()) % (r - l + 1) + l);
        Comparable temp = array[l];
        int j = l;
        // [l + 1...j] < temp
        // [j + 1...i)
        for (int i = l + 1; i <= r; i++) {
            if (array[i].compareTo(temp) > 0) {
                swap(array, i, ++j);
            }
        }
        swap(array, l, j);
        return j;
    }
}
