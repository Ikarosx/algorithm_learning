package 剑指offer.举例让抽象具体化.栈的压入弹出序列;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。 （注意：这两个序列的长度是相等的）
 *
 * @author Ikaros
 * @date 2020/03/12 20:49
 */
class SolutionTest {
  public boolean IsPopOrder(int[] pushA, int[] popA) {
    /*
     * 思路：
     * 遍历popA
     *  判断当前值在set中是否存在
     *    不存在
     *      遍历pushA，直到遇到当前弹出值，然后全部push进去栈
     *    存在
     *      pop值是否与当前值相等，不等则返回false
     *
     * 最优解：
     * 反过来了。。
     *
     */
    int popIndex = 0;
    Stack<Integer> stack = new Stack<>();
    for (int pushIndex = 0; pushIndex < pushA.length; pushIndex++) {
      stack.push(pushA[pushIndex]);
      while (!stack.empty() && stack.peek() == popA[popIndex]) {
        stack.pop();
        popIndex++;
      }
    }
    return stack.empty();
  }

  @Test
  void solution() {
    long l = System.currentTimeMillis();
    int[][] arrays = {{1, 2}, {3, 4}};
    int[] array1 = {1, 2, 3, 4, 5};
    int[] array2 = {4, 5, 3, 1, 2};
    boolean b = IsPopOrder(array1, array2);
    System.out.println(b);
    long l1 = System.currentTimeMillis();
    System.out.println(l1 - l);
  }
}
