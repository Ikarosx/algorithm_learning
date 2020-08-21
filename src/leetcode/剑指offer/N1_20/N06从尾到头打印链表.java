package leetcode.剑指offer.N1_20;

import helper.ListNodeHelper;
import java.util.Arrays;
import java.util.Stack;
import org.junit.jupiter.api.Test;
import 剑指offer.ListNode;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author Ikarosx
 * @date 2020/8/21 22:03
 */
public class N06从尾到头打印链表 {

    @Test
    public void test() {
        ListNode listNode = ListNodeHelper.generateListNodeByArray(new int[]{1, 3, 2});
        int[] ints = reversePrint(listNode);
        assert Arrays.equals(ints, new int[]{2, 3, 1});
    }

    /**
     * 栈写法
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] ints = new int[stack.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = stack.pop();
        }
        return ints;
    }


}
