package leetcode.list;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 * @author Ikaros
 *
 */
public class N21 {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 4 };
		int[] arr2 = { 1, 3, 4 };
		MyLinkedList.printList(mergeTwoLists(MyLinkedList.createListNode(arr1), MyLinkedList.createListNode(arr2)));
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode list = new ListNode(0), dummy = list;
		while (l1 != null && l2 != null) {
			int t1 = l1.val;
			int t2 = l2.val;
			if (t1 <= t2) {
				list.next = l1;
				l1 = l1.next;
			} else {
				list.next = l2;
				l2 = l2.next;
			}
			list = list.next;
		}
		if (l1 != null) {
			list.next = l1;
		}
		if (l2 != null) {
			list.next = l2;
		}
		return dummy.next;
	}
}
