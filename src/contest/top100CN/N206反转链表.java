package contest.top100CN;

import helper.ListNodeHelper;
import org.junit.jupiter.api.Test;
import 剑指offer.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list
 *
 * @author Ikarosx
 * @date 2020/7/12 21:23
 */
public class N206反转链表 {
    private ListNode head;
    
    @Test
    public void test() {
        ListNode listNode = ListNodeHelper.generateListNodeByArray(new int[]{1, 2, 3, 4, 5});
        ListNodeHelper.print(reverseList(listNode));
    }
    
    public ListNode reverseList(ListNode head) {
        if (head != null) {
            ListNode listNode = reverseListImpl(head);
            listNode.next = null;
        }
        return this.head;
    }
    
    private ListNode reverseListImpl(ListNode head) {
        if (head.next == null) {
            this.head = head;
            return head;
        }
        ListNode afterReverse = reverseListImpl(head.next);
        afterReverse.next = head;
        return head;
    }
}
