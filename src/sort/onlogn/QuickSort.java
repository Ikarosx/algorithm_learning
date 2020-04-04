package sort.onlogn;

import sort.on2.InsertionSort;

import java.util.Random;

/**
 * @author Ikaros
 * @date 2020/4/4 8:36
 */
public class QuickSort {
    public static void sort(Comparable[] array, Integer l, Integer r) {
        // 优化
        // if (r - l <= 15) {
        //     InsertionSort.sort(array, l, r);
        //     return;
        // }
        // 缺点：分出的两部分不一定平均
        // int p = partition2(array, l, r);
        // sort(array, l, p - 1);
        // sort(array, p + 1, r);
        partition3(array, l, r);
    }
    
    private static int partition(Comparable[] array, Integer l, Integer r) {
        // 优化，解决近乎有序退化成O(n^2)
        swap(array, l, Math.abs(new Random().nextInt()) % (r - l + 1) + l);
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
    
    /**
     * 解决重复值太多
     */
    private static int partition2(Comparable[] array, Integer l, Integer r) {
        // 优化，解决近乎有序退化成O(n^2)
        swap(array, l, Math.abs(new Random().nextInt()) % (r - l + 1) + l);
        Comparable temp = array[l];
        // array[l + 1, i) <= temp
        // array(j, r] >= temp
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && array[i].compareTo(temp) < 0) {
                i++;
            }
            while (j >= l + 1 && array[j].compareTo(temp) > 0) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(array, i++, j--);
        }
        swap(array, l, j);
        return j;
        
    }
    
    /**
     * QuickSort3Ways
     */
    private static void partition3(Comparable[] array, Integer l, Integer r) {
        if (r - l <= 15) {
            InsertionSort.sort(array, l, r);
            return;
        }
        // 优化，解决近乎有序退化成O(n^2)
        swap(array, l, Math.abs(new Random().nextInt()) % (r - l + 1) + l);
        Comparable temp = array[l];
        // array[l + 1, lt] < temp
        // array[lt + 1, i - 1] = temp
        // array[gt, r] > temp
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while (i < gt) {
            if (array[i].compareTo(temp) == 0) {
                // i元素相等
                i++;
            } else if (array[i].compareTo(temp) < 0) {
                // i元素小于目标值
                swap(array, i++, ++lt);
            } else {
                swap(array, i, --gt);
            }
        }
        swap(array, l, lt);
        partition3(array, l, lt - 1);
        partition3(array, gt, r);
        
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
