package contest.top100CN;

import 剑指offer.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author Ikarosx
 * @date 2020/7/7 8:43
 */
public class N141环形链表 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
