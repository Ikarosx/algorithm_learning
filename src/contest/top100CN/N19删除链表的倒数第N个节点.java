package contest.top100CN;

import 剑指offer.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author Ikaros
 * @date 2020/6/28 16:12
 */
public class N19删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode before = new ListNode(0);
        before.next = head;
        ListNode temp = before;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            before = before.next;
        }
        before.next = before.next.next;
        return temp.next;
    }
}
