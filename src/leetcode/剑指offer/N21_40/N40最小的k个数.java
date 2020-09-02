package leetcode.剑指offer.N21_40;

import java.util.Arrays;
import org.junit.Test;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [3,2,1], k = 2 输出：[1,2] 或者 [2,1] 示例 2：
 *
 * <p>输入：arr = [0,1,2,1], k = 1 输出：[0]
 *
 * <p>限制：
 *
 * <p>0 <= k <= arr.length <= 10000 0 <= arr[i] <= 10000
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/2 8:07
 */
public class N40最小的k个数 {
  @Test
  public void test() {
    System.out.println(Arrays.toString(getLeastNumbers(new int[] {1, 3, 5}, 1)));
  }

  public int[] getLeastNumbers(int[] arr, int k) {
    // 本题不要求输出数组要排序
    if (arr == null || arr.length == 0 || k == 0) {
      return new int[] {};
    }
    quickSort(arr, 0, arr.length - 1, k);
    return Arrays.copyOf(arr, k);
  }

  //  private int[] quickSort(int[] arr, int l, int r, int k) {
  //    int j = partition(arr, l, r);
  //    if (j == k - 1) {
  //      return Arrays.copyOf(arr, k);
  //    }
  //    return j <= k - 1 ? quickSort(arr, j + 1, r, k) : quickSort(arr, l, j - 1, k);
  //  }
  //
  //  private int partition(int[] arr, int l, int r) {
  //    // 随机标定点
  //    swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
  //    // 标定点
  //    int point = arr[l];
  //    // [l + 1, i] <= point
  //    int i = l + 1;
  //    // (j, r] >= point
  //    int j = r;
  //    while (true) {
  //      while (i <= r && arr[i] < point) {
  //        i++;
  //      }
  //      while (j >= l && arr[j] > point) {
  //        j--;
  //      }
  //      if (i > j) {
  //        break;
  //      }
  //      swap(arr, i++, j--);
  //    }
  //    // 此时i的位置应该为标定点最后所处位置
  //    swap(arr, j, l);
  //    return j;
  //  }

  private void quickSort(int[] arr, int l, int r, int k) {
    if (l > r) {
      return;
    }
    // 随机标定点
    //    swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
    // 标定点
    int point = arr[l];
    int i = l;
    // [l + 1, i] 小于等于point
    // [i + 1, r] 大于point
    for (int m = l + 1; m <= r; m++) {
      if (arr[m] <= point) {
        swap(arr, m, ++i);
      }
    }
    // 此时i的位置应该为标定点最后所处位置
    swap(arr, i, l);
    System.out.println(i);
    System.out.println(Arrays.toString(arr));
    if (i == k - 1) {
      return;
    }
    if (i < k) {
      quickSort(arr, i + 1, r, k);
    } else {
      quickSort(arr, l, i - 1, k);
    }
  }

  private void swap(int[] arr, int m, int i) {
    int temp = arr[m];
    arr[m] = arr[i];
    arr[i] = temp;
  }
}
