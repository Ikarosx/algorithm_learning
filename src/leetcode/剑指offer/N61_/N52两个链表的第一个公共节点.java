package leetcode.剑指offer.N61_;

import 剑指offer.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * @author Ikarosx
 * @date 2020/9/7 8:50
 */
public class N52两个链表的第一个公共节点 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 任意为空则返回
        if (headA == null || headB == null) {
            return null;
        }
        // 临时记录两个头结点
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (headA != headB) {
            // 不相等前进一步
            headA = headA.next;
            headB = headB.next;
            // 两者都为空说明没有公共结点，返回null
            if (headA == null && headB == null) {
                return null;
            }
            // 一方为空指向另一方的头结点，这样要么会相遇，要么最后两者为null，因为A+B的长度 = B+A的长度
            // a为空，指向B的头结点
            if (headA == null) {
                headA = tempB;
            }
            // b为空，指向A的头结点
            if (headB == null) {
                headB = tempA;
            }
        }
        return headA;
    }

}

