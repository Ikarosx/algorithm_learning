package simple;

import org.junit.jupiter.api.Test;

/** @Author: Ikaros @Date: 2020/1/11 10:15 */
public class SqrtOfX {
  @Test
  public void solution() {
    System.out.println(mySqrt(1));
  }

  /**
   * 思路分析：使用二分法搜索平方根的思想很简单，就类似于小时候我们看的电视节目中的“猜价格”游戏，高了就往低了猜，低了就往高了猜，范围越来越小。因此，使用二分法猜算术平方根就很自然。
   *
   * <p>一个数的平方根肯定不会超过它自己，不过直觉还告诉我们，一个数的平方根最多不会超过它的一半，例如 88 的平方根，88 的一半是 44，4^2=16>84 2
   * =16>8，如果这个数越大越是如此，因此我们要计算一下，这个边界是多少。为此，解如下不等式：
   *
   * <p>\left(\cfrac{a}{2}\right)^2 \ge a ( 2 a ​ ) 2 ≥a
   *
   * <p>意即：如果一个数的一半的平方大于它自己，那么这个数的取值范围。解以上不等式得 a \ge 4a≥4 或者 a \le 0a≤0。
   *
   * <p>于是边界值就是 44，那么对 00、11、22、33 分别计算结果，很容易知道，这 44 个数的平方根依次是 00、11、11、11。
   *
   * <p>注意：这 44 个特值如果没有考虑到，有可能导致你设置的搜索边界不正确。在使用二分法寻找平方根的时候，要特别注意边界值的选择，以下给出两个参考代码。
   *
   * <p>参考代码 1：所有的数都放在一起考虑，为了照顾到 00 把左边界设置为 00，为了照顾到 11 把右边界设置为 x // 2 + 1。
   *
   * <p>作者：liweiwei1419
   * 链接：https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param x
   * @return
   */
  public int mySqrt(int x) {
    long left = 0;
    long right = x / 2 + 1;
    while (left < right) {
      long mid = (left + right + 1) >>> 1;
      long square = mid * mid;
      if (square > x) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    return (int) left;
  }
}
