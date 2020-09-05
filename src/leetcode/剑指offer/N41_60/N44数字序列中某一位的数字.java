package leetcode.剑指offer.N41_60;

import org.junit.Assert;
import org.junit.Test;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * <p>请写一个函数，求任意第n位对应的数字。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：n = 3 输出：3 示例 2：
 *
 * <p>输入：n = 11 输出：0
 *
 * <p>限制：
 *
 * <p>0 <= n < 2^31
 *
 * <p>来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/3 8:18
 */
public class N44数字序列中某一位的数字 {
  @Test
  public void test() {
    Assert.assertEquals(3, findNthDigit(3));
    Assert.assertEquals(4, findNthDigit(19));
    Assert.assertEquals(1, findNthDigit(13));
  }

  public int findNthDigit(int n) {
    int digit = 1;
    long start = 1;
    // 记录当前记录值
    long count = 9;
    // 1.
    while (n > count) {
      n -= count;
      digit += 1;
      start *= 10;
      count = digit * start * 9;
    }
    // 2.
    // 当前值
    long num = start + (n - 1) / digit;
    // 3.
    // 转化当前字符
    return Long.toString(num).charAt((n - 1) % digit) - '0';
  }
}
