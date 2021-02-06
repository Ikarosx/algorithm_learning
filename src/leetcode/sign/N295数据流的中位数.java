package leetcode.sign;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 通过次数29,939提交次数58,998
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/2/5 9:57
 */
public class N295数据流的中位数 {
    // 大根堆
    private PriorityQueue<Integer> l;
    // 小根堆
    private PriorityQueue<Integer> r;

    /**
     * initialize your data structure here.
     */
    public N295数据流的中位数() {
        l = new PriorityQueue<>(Comparator.reverseOrder());
        r = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (l.isEmpty() || num <= l.peek()) {
            l.add(num);
        } else {
            r.add(num);
        }
        balance(l, r);
    }

    private void balance(PriorityQueue<Integer> l, PriorityQueue<Integer> r) {
        while (l.size() - r.size() >= 2) {
            r.add(l.poll());
        }
        while (r.size() - l.size() >= 1) {
            l.add(r.poll());
        }
    }

    public double findMedian() {
        if (l.size() > r.size()) {
            return l.peek();
        } else {
            return (l.peek() + r.peek()) / 2.0;
        }
    }

    @Test
    public void test() {
        N295数据流的中位数 o = new N295数据流的中位数();
        o.addNum(1);
        o.addNum(2);
        System.out.println(o.findMedian());
        o.addNum(3);
        System.out.println(o.findMedian());
    }
}
