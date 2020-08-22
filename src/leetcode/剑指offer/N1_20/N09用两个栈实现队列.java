package leetcode.剑指offer.N1_20;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2020/8/22 7:13
 */
public class N09用两个栈实现队列 {

    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    public N09用两个栈实现队列() {

    }

    /**
     * 每次添加把值添加到栈A
     */
    public void appendTail(int value) {
        A.push(value);
    }

    /**
     * 每次取出从B中取，如果B为空，A弹出后入B，再取，如果A也为空，返回-1
     */
    public int deleteHead() {
        // B不为空
        if (!B.isEmpty()) {
            return B.pop();
        }
        // AB都为空
        if (A.isEmpty()) {
            return -1;
        }
        // A弹出入B
        while (!A.isEmpty()) {
            B.push(A.pop());
        }
        // 返回B弹
        return B.pop();
    }
}
