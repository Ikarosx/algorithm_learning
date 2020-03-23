package sort.helper;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Ikaros
 * @date 2020/3/21 15:29
 */
public class SortTestHelper {
  /**
   * 生成具有length个元素，每个元素范围为[rangeL, rangeR]的数组
   *
   * @param length 数组长度
   * @param rangeL 元素最小值
   * @param rangeR 元素最大值
   * @return
   */
  public static Integer[] generateRandomArray(int length, int rangeL, int rangeR) {
    assert rangeL <= rangeR;
    Integer[] array = new Integer[length];
    Random random = new Random();
    for (int i = 0; i < array.length; i++) {
      int i1 = Math.abs(random.nextInt()) % (rangeR - rangeL + 1);
      array[i] = i1 + rangeL;
    }
    return array;
  }

  /**
   * 生成近乎有序的数组
   *
   * @param n
   * @param swapTimes 交换次数
   * @return
   */
  public static Integer[] generateNearlyOrderArray(int n, int swapTimes) {
    Integer[] integers = new Integer[n];
    for (int i = 0; i < integers.length; i++) {
      integers[i] = i;
    }
    Random random = new Random();
    for (int i = 0; i < swapTimes; i++) {
      int x = Math.abs(random.nextInt()) % n;
      int y = Math.abs(random.nextInt()) % n;
      swap(integers, x, y);
    }
    return integers;
  }

  /**
   * 打印数组前n个数
   *
   * @param arr 要打印的数组
   * @param n 打印长度
   * @param <T>
   */
  public static <T> void printArray(T[] arr, int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  /**
   * 打印整个数组
   *
   * @param arr
   * @param <T>
   */
  public static <T> void printArray(T[] arr) {
    printArray(arr, arr.length);
  }

  /**
   * 交换arr数组中j和i位置的元素
   *
   * @param arr
   * @param i
   * @param j
   * @param <T>
   */
  public static <T> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  /**
   * 判断arr数组是否有序
   *
   * @param arr
   * @return
   */
  public static boolean isSorted(Comparable[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i].compareTo(arr[i + 1]) > 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
   *
   * @param sortClassName
   * @param arr
   */
  public static void testSort(String sortClassName, Comparable[] arr) {

    // 通过Java的反射机制，通过排序的类名，运行排序函数
    try {
      // 通过sortClassName获得排序函数的Class对象
      Class sortClass = Class.forName(sortClassName);
      // 通过排序函数的Class对象获得排序方法
      Method sortMethod = sortClass.getMethod("sort", new Class[] {Comparable[].class});
      // 排序参数只有一个，是可比较数组arr
      Object[] params = new Object[] {arr};

      long startTime = System.currentTimeMillis();
      // 调用排序函数
      sortMethod.invoke(null, params);
      long endTime = System.currentTimeMillis();

      assert isSorted(arr);

      System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 复制数组
   *
   * @param array
   * @return
   */
  public static Integer[] copyIntegerArray(Integer[] array) {
    return Arrays.copyOf(array, array.length);
  }
}
