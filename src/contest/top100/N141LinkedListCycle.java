package contest.top100;

import 剑指offer.ListNode;

/**
 * @author Ikaros
 * @date 2020/6/1 11:33
 */
public class N141LinkedListCycle {
    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                return true;
            }
        }
        return false;
    }
}
