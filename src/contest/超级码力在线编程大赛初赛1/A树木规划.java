package contest.超级码力在线编程大赛初赛1;

import java.util.Deque;
import java.util.LinkedList;
import org.junit.Test;

/**
 * @author Ikarosx
 * @date 2020/8/29 10:02
 */
public class A树木规划 {

  @Test
  public void test() {
    System.out.println(treePlanning(new int[] {1, 2, 3, 5, 6}, 2));
  }

  /**
   * @param trees: the positions of trees.
   * @param d: the minimum beautiful interval.
   * @return: the minimum number of trees to remove to make trees beautiful.
   */
  public int treePlanning(int[] trees, int d) {
    // write your code here.
    Deque<Integer> queue = new LinkedList<>();
    int result = 0;
    for (int tree : trees) {
      if (queue.isEmpty() || (tree - queue.peek()) >= d) {
        queue.addFirst(tree);
      } else {
        result++;
      }
    }
    return result;
  }
}
