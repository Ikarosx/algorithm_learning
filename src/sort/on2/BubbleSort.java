package sort.on2;

import org.junit.Test;
import sort.helper.SortTestHelper;

import java.util.Arrays;

/**
 * 思路：重复遍历，每次查看相邻的两个，如果后面的数小于前面则交换，直到不需要交换
 *
 * @author Ikaros
 * @date 2020/3/22 17:03
 */
public class BubbleSort {
    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    SortTestHelper.swap(array, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    @Test
    public void test() {
        int[] arr = {3, 10, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        int flag = 0;
        for (int i = 0; i < arr.length - 1 && flag == 0; i++) {
            flag = 1;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = 0;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}