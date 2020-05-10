package 剑指offer.树;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 *
 * @author Ikaros
 * @date 2020/5/9 16:19
 */
public class 数据流中的中位数 {
    // 后半部分
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // 前半部分
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    
    int count = 0;
    
    public void Insert(Integer num) {
        count++;
        if ((count & 1) == 1) {
            // 奇数
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        } else {
            // 偶数
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        }
    }
    
    public Double GetMedian() {
        double result = 0;
        if ((count & 1) == 1) {
            result = maxHeap.peek();
        } else {
            result = (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return result;
    }
}
