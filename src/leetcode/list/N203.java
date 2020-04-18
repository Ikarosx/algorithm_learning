package leetcode.list;

/**
 * Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 * @author Ikaros
 *
 */
public class N203 {
	public static ListNode removeElements(ListNode head, int val) {
		ListNode pre = new ListNode(0), temp = pre;
		pre.next = head;
		while (temp.next != null) {
			if (temp.next.val == val) {
				temp.next = temp.next.next;
				temp.next.next = null;
			} else {
				temp = temp.next;
			}
		}
		return pre.next;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 6, 3, 4, 5, 6 };
		int target = 6;
		MyLinkedList.printList(removeElements(MyLinkedList.createListNode(arr), target));
	}
}
