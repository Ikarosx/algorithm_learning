package 剑指offer.代码的完整性.数值的整数次方;

import org.junit.jupiter.api.Test;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * <p>保证base和exponent不同时为0
 *
 * @author Ikaros
 * @date 2020/03/11 11:02
 */
class SolutionTest {
  public double Power(double base, int exponent) {
    if (base == 0) {
      return 0;
    }
    if (exponent == 0) {
      return 1;
    }
    double res = 1.0;
    int n = exponent;
    exponent = exponent < 0 ? -exponent : exponent;
    // 先计算最大平方
    while (exponent != 0) {
      if ((exponent & 1) == 1) {
        res *= base;
      }
      base *= base;
      exponent >>= 1;
    }
    return n >= 0 ? res : 1 / res;
  }

  @Test
  void solution() {
    long l = System.currentTimeMillis();
    System.out.println(Power(2, 3));
    long l1 = System.currentTimeMillis();
    System.out.println(l1 - l);
  }
}
