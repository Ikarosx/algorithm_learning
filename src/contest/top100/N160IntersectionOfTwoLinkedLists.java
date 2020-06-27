package contest.top100;

import 剑指offer.ListNode;

/**
 * @author Ikaros
 * @date 2020/6/9 10:14
 */
public class N160IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode headATemp = headA;
        ListNode headBTemp = headB;
        while (headATemp != headBTemp) {
            headATemp = headATemp.next;
            headBTemp = headBTemp.next;
            if (headATemp == headBTemp) {
                return headATemp;
            }
            if (headATemp == null) {
                headATemp = headB;
            }
            if (headBTemp == null) {
                headBTemp = headA;
            }
        }
        return headATemp;
    }
}
