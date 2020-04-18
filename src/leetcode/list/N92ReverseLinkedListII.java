package leetcode.list;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 * @author Ikaros
 *
 */
public class N92ReverseLinkedListII {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		int i = 1;
		while (i < m) {
			pre = pre.next;
			i++;
		}
		ListNode cur = pre.next, next = cur.next;
		ListNode temp = pre;
		ListNode temp1 = pre.next;
		while (cur != null && i <= n) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			i++;
		}
		temp.next = pre;
		temp1.next = cur;
		return dummy.next;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		ListNode reverseList = reverseBetween(MyLinkedList.createListNode(arr), 2, 3);
		MyLinkedList.printList(reverseList);
	}
}
