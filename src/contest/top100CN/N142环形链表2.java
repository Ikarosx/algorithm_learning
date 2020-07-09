package contest.top100CN;

import 剑指offer.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author Ikarosx
 * @date 2020/7/8 8:15
 */
public class N142环形链表2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = head;
                while (temp != fast) {
                    fast = fast.next;
                    temp = temp.next;
                }
                return temp;
            }
        }
        return null;
    }
}
