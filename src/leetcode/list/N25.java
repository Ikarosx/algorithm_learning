package leetcode.list;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
 * @author Ikaros
 *
 */
public class N25 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 3;
		MyLinkedList.printList(reverseKGroup(MyLinkedList.createListNode(arr), k));
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		int count = 0;
		ListNode dummy = new ListNode(0), pre = dummy, cur = head, end, endP;
		dummy.next = head;
		while (cur != null) {
			if (++count == k) {
				endP = cur.next;
				cur.next = null;
				ListNode reverse = reverse(pre.next);
				end = pre.next;
				end.next = endP;
				pre.next = reverse;
				pre = end;
				cur = endP;
				count = 0;
				continue;
			}
			cur = cur.next;
		}
		return dummy.next;
	}

	private static ListNode reverse(ListNode head) {
		ListNode pre = new ListNode(0), cur = head, next;
		pre.next = head;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
