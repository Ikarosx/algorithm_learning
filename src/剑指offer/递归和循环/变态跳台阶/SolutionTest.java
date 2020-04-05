package 剑指offer.递归和循环.变态跳台阶;

import org.junit.jupiter.api.Test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author Ikaros
 * @date 2020/03/10 10:16
 */
class SolutionTest {
  public int JumpFloorII(int target) {
    /*
     * 根据普通跳台阶的分析
     * n层跳法 = 从第1层跳到第n-1层的跳法和 + 1(从0层直接跳到n层)
     * 又因为第n - 1层的跳法= 从第1层跳到n - 2层 + 1
     * 即n - 1层跳法 - 1 = 从第1层跳到n - 2层
     * 第1层跳到第n-1层 = 第1层跳到n - 2层 + 第n - 1层 = 2*fn(n - 1)
     */
    if (target <= 0) {
      return 0;
    }
    if (target == 1 || target == 2) {
      return target;
    }
    int before = 1;
    int after = 2;
    while (target-- > 2) {
      after = 2 * after;
      before = after / 2;
    }
    return after;
  }

  @Test
  void solution() {
    long l = System.currentTimeMillis();
    int[] ints = {7, 7, 8, 2, 3, 4, 5, 6};
    long l1 = System.currentTimeMillis();
    System.out.println(l1 - l);
  }
}
