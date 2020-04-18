package leetcode.list;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 * @author Ikaros
 *
 */
public class N61 {
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) {
			return head;
		}
		ListNode dummy = new ListNode(0), cur = head, pre = dummy;
		dummy.next = head;

		for (int i = 1; i < k; i++) {
			cur = cur.next;
			if (cur == null) {
				cur = head;
				k = k % i;
				i = 0;
				if (k == 0) {
					return dummy.next;
				}
			}
		}
		while (cur.next != null) {
			cur = cur.next;
			pre = pre.next;
		}
		if (pre.next != head) {
			cur.next = dummy.next;
			dummy.next = pre.next;

			pre.next = null;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 10;
		MyLinkedList.printList(rotateRight(MyLinkedList.createListNode(arr), k));
	}
}
