package test;

import org.junit.jupiter.api.Test;
import sort.helper.SortTestHelper;
import sort.on2.InsertionSort;
import sort.onlogn.MergeSort;

import java.util.Arrays;

/**
 * @author Ikaros
 * @date 2020/3/21 15:34
 */
public class SortTest {
  @Test
  public void generateTest() {
    int n = 50000;
    Integer[] ints1 = SortTestHelper.generateRandomArray(n, 0, n);
    Integer[] ints2 = SortTestHelper.copyIntegerArray(ints1);
    SortTestHelper.testSort(MergeSort.class.getName(), ints1);
    SortTestHelper.testSort(InsertionSort.class.getName(), ints2);
  }
}
