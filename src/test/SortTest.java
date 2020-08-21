package test;

import org.junit.Test;
import sort.helper.SortTestHelper;
import sort.onlogn.HeapSort;
import sort.onlogn.MergeSort;
import sort.onlogn.QuickSort;

/**
 * @author Ikaros
 * @date 2020/3/21 15:34
 */
public class SortTest {

    @Test
    public void generateTest() {
        int n = 1000;
        Integer[] ints1 = SortTestHelper.generateRandomArray(n, 0, n);
        // Integer[] ints1 = SortTestHelper.generateNearlyOrderArray(n, 100);
        Integer[] ints2 = SortTestHelper.copyIntegerArray(ints1);
        Integer[] ints3 = SortTestHelper.copyIntegerArray(ints1);
        SortTestHelper.testSort(MergeSort.class.getName(), ints1, 0, n - 1);
        SortTestHelper.testSort(QuickSort.class.getName(), ints2, 0, n - 1);
        SortTestHelper.testSort(HeapSort.class.getName(), ints3, 0, n - 1);
    }
}
