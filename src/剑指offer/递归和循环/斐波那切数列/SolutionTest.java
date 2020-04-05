package 剑指offer.递归和循环.斐波那切数列;

import org.junit.jupiter.api.Test;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。 n<=39
 *
 * @author Ikaros
 * @date 2020/03/10 10:16
 */
class SolutionTest {
  public int Fibonacci(int n) {
    /*
    * 迭代应该大家都能写出来
    * 不过我写的是3个变量的版本，实际上可以优化成2个变量
    * while (n-- > 2) {
        after += before;
        before = after - before;
      }
    *
    * 至于递归我的第一反应就是会栈溢出
    * 但因此啪啪啪打脸
    * 第一次听说有一种东西叫做尾递归
    * 在js里好像也有个叫做柯西化的
    * 这个就不清楚了
    */
    if (n <= 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int before = 1;
    int after = 1;
    while (n-- > 2) {
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
