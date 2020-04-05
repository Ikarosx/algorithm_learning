package 剑指offer.栈和队列.用两个栈实现队列;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @author Ikaros
 * @date 2020/03/08 08:20
 */
class SolutionTest {
  Stack<Integer> stack1 = new Stack<Integer>();
  Stack<Integer> stack2 = new Stack<Integer>();

  public void push(int node) {
    /*
     * 我的思路：
     * push的时候
     * 将stack2全部pop然后存入stack1
     * 然后push在stack1上
     * 再将stack1全部pop存入Stack2
     *
     * pop的时候
     * 直接pop stack2即可
     */
    /*
     * 别人的思路：
     * push的时候
     * 直接push在stack1上
     *
     * pop的时候：
     * 判断stack2是否为空
     * 为空的时候
     * 将stack1全部pop然后push进stack2，返回stack2.pop
     * 不为空的时候
     * 返回stack2.pop
     *
     * 比起我的思路巧妙在不用每次都将stack1 pop
     * 因为stack2存的就是已经是队列的顺序
     * 所以仅当stack2为空才执行一次stack1的pop
     *
     */
    stack1.push(node);
  }

  public int pop() {
    if (stack1.empty() && stack2.empty()) {
      throw new RuntimeException("Queue is empty!");
    }
    if (stack2.empty()) {
      while (!stack1.empty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }

  @Test
  void solution() {
    long l = System.currentTimeMillis();
    long l1 = System.currentTimeMillis();
    System.out.println(l1 - l);
  }
}
