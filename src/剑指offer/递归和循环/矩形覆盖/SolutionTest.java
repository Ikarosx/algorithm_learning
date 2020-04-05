package 剑指offer.递归和循环.矩形覆盖;

import org.junit.jupiter.api.Test;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？ 比如n=3时，2*3的矩形块有3种覆盖方法：
 *
 * @author Ikaros
 * @date 2020/03/10 11:36
 */
class SolutionTest {
  public int RectCover(int target) {
    /*
     * 我的思路
     * 从1个开始，宽为2，高为n
     * ①1个的时候，只能横放，一共1
     * ②2个的时候，在上一种数量的基础上，底部加上横放，即加上上一种数量1
     * 又因为在上一种所有情况下，如果底部本身横放，那么说明该横放可以和新的块组成竖放
     * 上一种情况的底部横放的情况有1种，说明新的竖放也有一种
     * 所以横放一种竖放一种，一共2
     * ③3个的时候，在上一种数量的基础上，底部加上横放，即加上上一种数量2
     * 然后加上上一种底部本身横放的数量凑成竖放，1种
     * 所以横放2竖放1，一共3
     * ④观察可知，当前2*n的覆盖方法 = 2 * (n - 1)的覆盖方法 + 2 * (n - 1)的情况下底部为横放的数量
     * 而实际上 2 * (n - 1)的情况下底部为横放的数量 = 2 * (n - 2)的数量
     * 即fn(n) = fn(n - 1) + fn(n - 2)
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
