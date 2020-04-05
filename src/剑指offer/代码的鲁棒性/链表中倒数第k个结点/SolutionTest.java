package 剑指offer.代码的鲁棒性.链表中倒数第k个结点;

import org.junit.jupiter.api.Test;
import 剑指offer.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author Ikaros
 * @date 2020/03/11 20:57
 */
class SolutionTest {
    public ListNode FindKthToTail(ListNode head, int k) {
        /*
         * 暴力
         *
         * 双索引
         * 索引left，right指向头
         * 循环
         * 索引right走到第k个结点后
         * right每走下一个结点
         * left也走下一个结点
         * 当right到底
         * left索引所在结点就是倒数第k个结点
         */
        if (head == null || k <= 0) {
            return null;
        }
        // count表示当前是第几个结点
        int count = 1;
        ListNode left = head;
        ListNode right = head;
        //    while (count++ < k) {
        //      right = right.next;
        //      if (right == null) {
        //        return null;
        //      }
        //    }
        //    while (right.next != null) {
        //      right = right.next;
        //      left = left.next;
        //    }
        while (right.next != null) {
            right = right.next;
            count++;
            if (count > k) {
                left = left.next;
            }
        }
        if (count <= k) {
            return null;
        }
        return left;
    }
    
    @Test
    void solution() {
        long l = System.currentTimeMillis();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
