package leetcode.剑指offer.N41_60;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.Test;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * <p>例如，
 *
 * <p>[2,3,4] 的中位数是 3
 *
 * <p>[2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * <p>设计一个支持以下两种操作的数据结构：
 *
 * <p>void addNum(int num) - 从数据流中添加一个整数到数据结构中。 double findMedian() - 返回目前所有元素的中位数。 示例 1：
 *
 * <p>输入： ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]] 输出：[null,null,null,1.50000,null,2.00000] 示例 2：
 *
 * <p>输入： ["MedianFinder","addNum","findMedian","addNum","findMedian"] [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *
 * <p>限制：
 *
 * <p>最多会对 addNum、findMedia进行 50000 次调用。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/2 10:02
 */
public class N41数据流中的中位数 {
  @Test
  public void test() {
    N41数据流中的中位数 n41 = new N41数据流中的中位数();
    n41.addNum(6);
    System.out.println(n41.findMedian());
    n41.addNum(10);
    System.out.println(n41.findMedian());
    n41.addNum(2);
    System.out.println(n41.findMedian());
    n41.addNum(6);
    System.out.println(n41.findMedian());
    n41.addNum(5);
    System.out.println(n41.findMedian());
    n41.addNum(0);
    System.out.println(n41.findMedian());
  }

  List<Integer> data;
  boolean single = false;
  // 如果奇数则是当前最中间，如果是偶数则是左边那个
  int singleIndex = -1;
  double median = 0;

  Queue<Integer> A, B;
  /** initialize your data structure here. */
  public N41数据流中的中位数() {
    //    data = new ArrayList<>();
    // 小顶堆，保存较大的一半
    A = new PriorityQueue<>();
    // 大顶堆，保存较小的一半
    B = new PriorityQueue<>((x, y) -> (y - x));
  }

  public void addNum(int num) {
    // 堆
    if (A.size() != B.size()) {
      A.add(num);
      B.add(A.poll());
    } else {
      B.add(num);
      A.add(B.poll());
    }
  }

  public double findMedian() {
    return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
  }

  public void addNumBySearch(int num) {
    // 二分查找
    if (data.isEmpty()) {
      data.add(num);
    } else {
      int l = 0;
      int r = data.size() - 1;
      while (true) {
        int mid = (r - l) / 2 + l;
        Integer current = data.get(mid);
        if (current == num) {
          data.add(mid, num);
          break;
        } else if (current < num) {
          if (mid == r) {
            // 结尾
            data.add(r + 1, num);
            break;
          } else if (data.get(mid + 1) >= num) {
            data.add(mid + 1, num);
            break;
          }
          l = mid + 1;
        } else {
          if (mid == 0) {
            data.add(0, num);
            break;
          } else if (data.get(mid - 1) <= num) {
            data.add(mid, num);
            break;
          }
          r = mid - 1;
        }
      }
    }
    if (single) {
      // 未添加之前是奇数
      median = (data.get(singleIndex) + data.get(singleIndex + 1)) / 2.0;
    } else {
      // 偶数
      median = data.get(++singleIndex);
    }
    single = !single;
  }

  public double findMedianBySort() {
    return median;
  }
}
