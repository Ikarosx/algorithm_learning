package contest.top100CN;

import 剑指offer.ListNode;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author Ikarosx
 * @date 2020/7/12 20:14
 */
public class N160相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode headAA = headA;
        ListNode headBB = headB;
        while (headAA != headBB) {
            headAA = headAA == null ? headB : headAA.next;
            headBB = headBB == null ? headA : headBB.next;
        }
        return headAA;
    }
}
