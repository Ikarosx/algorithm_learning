package 剑指offer.时间空间效率的平衡.数组中的逆序对;

import org.junit.jupiter.api.Test;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * @author Ikaros
 * @date 2020/5/6 14:33
 */
public class Solution {
    int result = 0;
    
    @Test
    public void test() {
        System.out.println(InversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0}));
    }
    
    public int InversePairs(int[] array) {
        mergeSort(array, 0, array.length - 1);
        return result;
    }
    
    /**
     * 对[l...r]范围内进行归并排序
     *
     * @param array
     * @param l
     * @param r
     */
    private void mergeSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (r - l) / 2 + l;
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);
        merge(array, l, mid, r);
    }
    
    private void merge(int[] array, int l, int mid, int r) {
        // [l...mid] 左半部分
        // [mid+1...r] 右半部分
        int[] ints = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            ints[i - l] = array[i];
        }
        int m = l;
        int n = mid + 1;
        for (int i = l; i <= r; i++) {
            if (m > mid) {
                array[i] = ints[n - l];
                result += mid - m + 1;
                result %= 1000000007;
                n++;
            } else if (n > r) {
                array[i] = ints[m - l];
                m++;
            } else if (ints[m - l] <= ints[n - l]) {
                array[i] = ints[m - l];
                m++;
            } else {
                array[i] = ints[n - l];
                result += mid - m + 1;
                result %= 1000000007;
                n++;
            }
        }
    }
}
