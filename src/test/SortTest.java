package test;

import org.junit.jupiter.api.Test;
import sort.helper.SortTestHelper;
import sort.onlogn.MergeSort;
import sort.onlogn.MergeSortBottomUp;

/**
 * @author Ikaros
 * @date 2020/3/21 15:34
 */
public class SortTest {
    @Test
    public void generateTest() {
        int n = 50000;
        Integer[] ints1 = SortTestHelper.generateRandomArray(n, 0, n);
        // Integer[] ints1 = SortTestHelper.generateNearlyOrderArray(n, 10);
        Integer[] ints2 = SortTestHelper.copyIntegerArray(ints1);
        SortTestHelper.testSort(MergeSort.class.getName(), ints1, 0, n - 1);
        SortTestHelper.testSort(MergeSortBottomUp.class.getName(), ints2, 0, n - 1);
    }
}
