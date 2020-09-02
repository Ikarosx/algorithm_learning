package leetcode.剑指offer.N41_60;

import org.junit.Assert;
import org.junit.Test;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * <p>例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：n = 12 输出：5 示例 2：
 *
 * <p>输入：n = 13 输出：6
 *
 * <p>限制：
 *
 * <p>1 <= n < 2^31
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/2 11:22
 */
public class N431_n整数中1出现的次数 {
  @Test
  public void test() {
    Assert.assertEquals(5, countDigitOne(12));
    Assert.assertEquals(6, countDigitOne(13));
  }

  public int countDigitOne(int n) {
    // https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
    // 牛逼。。
    int result = 0;
    int digit = 1;
    int high = n / 10;
    int cur = n % 10;
    int low = 0;
    // 当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
    while (high != 0 || cur != 0) {
      if (cur == 0) {
        result += high * digit;
      } else if (cur == 1) {
        result += high * digit + low + 1;
      } else {
        result += (high + 1) * digit;
      }
      // 将 cur 加入 low ，组成下轮 low
      low += cur * digit;
      // 下轮 cur 是本轮 high 的最低位
      cur = high % 10;
      // 将本轮 high 最低位删除，得到下轮 high
      high /= 10;
      // 位因子每轮 × 10
      digit *= 10;
    }
    return result;
  }
}
