package 剑指offer.递归和循环.跳台阶;

import org.junit.jupiter.api.Test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @author Ikaros
 * @date 2020/03/10 10:16
 */
class SolutionTest {
  public int JumpFloor(int target) {
    /*
     * 如果target <= 0, return 0
     * 当target为1,有1种选择，即跳一次1阶
     * 当target为2,有2种选择，即跳两次1阶或一次2阶
     * 当target为3,有3种选择...
     * 其实这可以看成fn(target) = fn(target - 1) + fn(target - 2)
     * 因为你可以走的步数是1和2
     * 所以跳到target层的次数
     * =
     * 距离终点还差1步时的次数(此时只能有跳1步的选择，相当于 * 1)
     * +
     * 距离终点还差2步时的次数
     * (此时只能有跳2步这一种选择，相当于* 1
     * 别问我为什么不能跳1再跳1，因为这种情况被包含在距离终点还差1步的情况)
     * 又是斐波那切数列
     */
    if (target <= 0) {
      return 0;
    }
    if (target == 1) {
      return 1;
    }
    if (target == 2) {
      return 2;
    }
    int before = 1;
    int after = 2;
    while (target-- > 2) {
      after += before;
      before = after - before;
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
