package leetcode.list;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
 * @author Ikaros
 *
 */
public class N19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0), cur = head, pre = dummy;
		dummy.next = head;
		int count = 0;
		while (cur != null) {
			if (count != n) {
				cur = cur.next;
				count++;
			} else {
				while (cur != null) {
					dummy = dummy.next;
					cur = cur.next;
				}
			}
		}
		dummy.next = dummy.next.next;
		return pre.next;
	}
}
