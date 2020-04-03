package test;

import org.junit.jupiter.api.Test;
import sort.on2.InsertionSort;
import sort.on2.ShellSort;
import sort.helper.SortTestHelper;

/**
 * @author Ikaros
 * @date 2020/3/21 15:34
 */
public class SortTest {
  @Test
  public void generateTest() {
    int n = 100;
    Integer[] ints1 = SortTestHelper.generateRandomArray(n, 0, n);
    Integer[] ints2 = SortTestHelper.copyIntegerArray(ints1);
    SortTestHelper.testSort(ShellSort.class.getName(), ints1);
    SortTestHelper.testSort(InsertionSort.class.getName(), ints2);
  }
}
