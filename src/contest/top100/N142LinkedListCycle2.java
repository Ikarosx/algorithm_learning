package contest.top100;

import 剑指offer.ListNode;

/**
 * @author Ikaros
 * @date 2020/6/1 11:43
 */
public class N142LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                ListNode temp = head;
                while (temp != slowPointer) {
                    temp = temp.next;
                    slowPointer = slowPointer.next;
                }
                return temp;
            }
        }
        return null;
    }
}
