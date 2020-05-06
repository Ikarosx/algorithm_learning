package 剑指offer.位运算.二进制中1的个数;


import org.junit.jupiter.api.Test;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @author Ikaros
 * @date 2020/03/11 09:11
 */
class SolutionTest {
  public int NumberOf1(int n) {
    /*
     * 通过n & 1来计算最后一位，如果结果为1，则说明1的个数+1，然后将n左移1位
     * 如果为负数则判断最左边
     * 更正：可以无符号右移
     */

    /*
     * 别人的思路
     * 用1（1自身左移运算，其实后来就不是1了）和n的每位进行位与，来判断1的个数
     */

    /*
     * 最优解
     * n = n & (n - 1);
     * 如果一个整数不为0，那么这个整数至少有一位是1。
     * 如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，
     * 原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。
     * 其余所有位将不会受到影响。
     */
    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        count++;
      }
      n = n >>> 1;
    }
    return count;
  }

  @Test
  void solution() {
    long l = System.currentTimeMillis();
    int[] ints = {7, 7, 8, 2, 3, 4, 5, 6};
    long l1 = System.currentTimeMillis();
    int n = 11;
    //    System.out.println( >> 1);

    System.out.println(NumberOf1(-1));
    //    System.out.println(l1 - l);
  }
}
