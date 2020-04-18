package interview.腾讯2020校园招聘;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 作为程序员的小Q，他的数列和其他人的不太一样，他有2^n个数。
 * 老板问了小Q一共 m次，每次给出一个整数qi(1<=i<=m), 要求小Q把这些数每2^qi分为一组，
 * 然后把每组进行翻转，小Q想知道每次操作后整个序列中的逆序对个数是多少呢？
 * <p>
 * 例如:
 * 对于序列1 3 4 2，逆序对有(4, 2),(3, 2),总数量为2。
 * 翻转之后为2 4 3 1，逆序对有(2, 1),(4, 3), (4, 1), (3, 1),总数量为4。
 * <p>
 * 输入描述:
 * 第一行一个数n
 * 第二行2^n个数，表示初始的序列()
 * 第三行一个数m
 * 第四行m个数表示
 * <p>
 * 输出描述:
 * m行每行一个数表示答案。
 * <p>
 * 输入例子1:
 * 2
 * 2 1 4 3
 * 4
 * 1 2 0 2
 * <p>
 * 输出例子1:
 * 0
 * 6
 * 6
 * 0
 * <p>
 * 例子说明1:
 * 初始序列2 1 4 3
 * 2^{q_1} = 2 ->
 * 第一次：1 2 3 4 -> 逆序对数为0
 * 2^{q_2} = 4 ->
 * 第二次：4 3 2 1 -> 逆序对数为6
 * 2^{q_3} = 1 ->
 * 第三次：4 3 2 1 -> 逆序对数为6
 * 2^{q_4} = 4 ->
 * 第四次：1 2 3 4 -> 逆序对数为0
 *
 * @author Ikaros
 * @date 2020/4/13 20:06
 */
public class ReversePair {
    static int[] ints = null;
    static int count = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ints = new int[(int) Math.pow(2, n)];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            reversePair(scanner.nextInt());
        }
        scanner.close();
    }
    
    private static int reversePair(int m) {
        int result = 0;
        // 2^n个分为一组颠倒
        int n = (int) Math.pow(2, m);
        for (int i = 0; i < ints.length; i += n) {
            reverseArray(i, i + n - 1);
        }
        // 清空
        count = 0;
        // 归并排序计算逆序对
        int[] temp = Arrays.copyOf(ints, ints.length);
        mergeSort(temp, 0, ints.length - 1);
        System.out.println(count);
        return result;
    }
    
    private static void mergeSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (r - l) / 2 + l;
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);
        merge(array, l, mid, r);
    }
    
    private static void merge(int[] array, int l, int mid, int r) {
        int[] ints = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            ints[i - l] = array[i];
        }
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                array[k] = ints[j++ - l];
            } else if (j > r) {
                array[k] = ints[i++ - l];
            } else if (ints[i - l] <= ints[j - l]) {
                array[k] = ints[i++ - l];
            } else {
                // 在这里进行count加
                count += mid - i + 1;
                array[k] = ints[j++ - l];
            }
        }
    }
    
    private static void reverseArray(int i, int j) {
        for (int m = 0; m <= (j - i) / 2; m++) {
            int temp = ints[i + m];
            ints[i + m] = ints[j - m];
            ints[j - m] = temp;
        }
    }
    
}
