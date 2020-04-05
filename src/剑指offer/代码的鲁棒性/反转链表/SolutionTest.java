package 剑指offer.代码的鲁棒性.反转链表;

import org.junit.jupiter.api.Test;
import 剑指offer.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @author Ikaros
 * @date 2020/03/11 21:57
 */
class SolutionTest {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode before = head;
        ListNode mid = head.next;
        ListNode after = mid == null ? null : mid.next;
        before.next = null;
        while (mid != null) {
            mid.next = before;
            before = mid;
            mid = after;
            after = after == null ? null : after.next;
        }
        return before;
    }
    
    @Test
    void solution() {
        long l = System.currentTimeMillis();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode = ReverseList(listNode1);
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
