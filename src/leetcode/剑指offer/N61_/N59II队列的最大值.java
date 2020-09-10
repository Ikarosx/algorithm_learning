package leetcode.剑指offer.N61_;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/9/10 21:51
 */
public class N59II队列的最大值 {

    Deque<Integer> data;
    Deque<Integer> maxQueue;

    public N59II队列的最大值() {
        data = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        return maxQueue.size() == 0 ? -1 : maxQueue.peekFirst();
    }

    public void push_back(int value) {
        data.addFirst(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);
    }

    public int pop_front() {
        if (data.size() == 0) {
            return -1;
        }
        if (data.peekLast().equals(maxQueue.peekFirst())) {
            maxQueue.removeFirst();
        }
        return data.pollLast();
    }
}
