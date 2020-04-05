package 剑指offer.举例让抽象具体化.包含min函数的栈;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 *
 * @author Ikaros
 * @date 2020/03/12 15:18
 */
class SolutionTest {
  private int[] array = new int[100];
  private int size = 0;
  private int min = Integer.MAX_VALUE;
  private Stack<Integer> stack = new Stack<>();

  public void push(int node) {
    // 扩容
    if (size == array.length) {
      ensureCapacityHelper(size + 1);
    }
    array[size++] = node;

    if (node <= min) {
      stack.push(node);
      min = node;
    } else {
      stack.push(min);
    }
  }

  private void ensureCapacityHelper(int i) {
    int[] newArray = new int[i * 2];
    System.arraycopy(array, 0, newArray, 0, size);
    array = newArray;
  }

  public void pop() {
    if (size == 0) {
      throw new RuntimeException("栈为空");
    }
    size--;
    stack.pop();
    min = stack.peek();
  }

  private void reCalcMin() {
    min = Integer.MAX_VALUE;
    for (int i = 0; i < size; i++) {
      min = min < array[i] ? min : array[i];
    }
  }

  public int top() {
    if (size == 0) {
      throw new RuntimeException("栈为空");
    }
    return array[size - 1];
  }

  public int min() {
    if (size == 0) {
      throw new RuntimeException("栈为空");
    }
    return min;
  }

  @Test
  void solution() {
    long l = System.currentTimeMillis();
    int[][] arrays = {{1, 2}, {3, 4}};
    push(3);
    push(4);
    push(2);
    System.out.println(min);
    pop();
    System.out.println(min);
    long l1 = System.currentTimeMillis();
    System.out.println(l1 - l);
  }
}
