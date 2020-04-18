package leetcode.list;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
 * @author Ikaros
 *
 */
public class N24 {
	public static ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0), pre = dummy, cur = head, next;
		dummy.next = head;
		while (cur != null && cur.next != null) {
			next = cur.next;
			pre.next = next;
			cur.next = next.next;
			next.next = cur;
			cur = cur.next;
			pre = next.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		MyLinkedList.printList(swapPairs(MyLinkedList.createListNode(arr)));
	}
}
