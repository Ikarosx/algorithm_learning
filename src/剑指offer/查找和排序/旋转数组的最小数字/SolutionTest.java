package 剑指offer.查找和排序.旋转数组的最小数字;

import org.junit.jupiter.api.Test;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author Ikaros
 * @date 2020/03/08 08:20
 */
class SolutionTest {
  public int minNumberInRotateArray(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }
    /*
     * 思路一：
     * 暴力
     *
     * 思路二：
     * 二分
     * 记录左右索引
     * 每次取中间数，比较中间数mid与第一个数first
     * 如果mid < first rightIndex = mid
     * 如果mid > first leftIndex = mid
     * 不过上面解法无法实现重复数字
     *
     * 如果判断为重复，采用顺序法
     */
    int left = 0;
    int right = array.length - 1;
    int first = array[0];
    int midIndex = 0;
    while (array[left] >= array[right]) {
      if ((left + 1) == right) {
        midIndex = right;
        break;
      }
      midIndex = (right - left) / 2 + left;
      // array[left] array[right] array[mid]三者相等
      // 无法确定中间元素是属于前面还是后面的递增子数组
      // 只能顺序查找
      if (array[left] == array[right] && array[left] == array[midIndex]) {
        return MinOrder(array, left, right);
      }
      if (array[midIndex] > first) {
        left = midIndex;
      } else {
        right = midIndex;
      }
    }
    return array[midIndex];
  }

  private int MinOrder(int[] array, int left, int right) {
    int min = array[left];
    for (left++; left <= right; left++) {
      if (array[left] < min) {
        return array[left];
      }
      min = array[left];
    }
    return min;
  }

  @Test
  void solution() {
    long l = System.currentTimeMillis();
    int[] ints = {7, 7, 8, 2, 3, 4, 5, 6};
    System.out.println(minNumberInRotateArray(ints));
    long l1 = System.currentTimeMillis();
    System.out.println(l1 - l);
  }
}
