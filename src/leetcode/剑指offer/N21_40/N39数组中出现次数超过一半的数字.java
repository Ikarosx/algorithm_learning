package leetcode.剑指offer.N21_40;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * <p>
 *
 * <p>你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: [1, 2, 3, 2, 2, 2, 5, 4, 2] 输出: 2
 *
 * <p>来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * <p>限制：
 *
 * <p>1 <= 数组长度 <= 50000
 *
 * @author Ikarosx
 * @date 2020/9/2 6:51
 */
public class N39数组中出现次数超过一半的数字 {
  @Test
  public void test() {
    Assert.assertEquals(2, majorityElement(new int[] {1, 2, 3, 2, 2, 2, 5, 4, 2}));
  }

  public int majorityElementBySort(int[] nums) {
    // 排序
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }

  public int majorityElement(int[] nums) {
    // 摩尔投票法
    int vote = 0;
    int x = 0;
    for (int i : nums) {
      if (vote == 0) {
        x = i;
      }
      vote += x == i ? 1 : -1;
    }
    // 验证 x 是否为众数
    int count = 0;
    for (int num : nums) {
      if (num == x) {
        count++;
      }
    }
    // 当无众数时返回 0
    return count > nums.length / 2 ? x : 0;
  }
}
