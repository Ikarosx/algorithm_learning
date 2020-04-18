package leetcode.list;

public class N83RemoveDuplicatesfromSortedList {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pre = head;
		ListNode current = head.next;
		while (current != null) {
			if (current.val != pre.val) {
				pre.next = current;
				pre = current;
			}
			current = current.next;
		}
		pre.next = null;
		return head;
	}
	public static ListNode deleteDuplicates1(ListNode head) {
		if (head == null) {
			return null;
		}
		int temp = head.val;
		ListNode tempNode = head.next;
		ListNode lastNode = head;
		while (tempNode != null) {
			if (tempNode.val != temp) {
				lastNode.next = tempNode;
				lastNode = tempNode;
				temp = lastNode.val;
			}
			tempNode = tempNode.next;
		}
		lastNode.next = null;
		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 3 };
		MyLinkedList.printList(deleteDuplicates(MyLinkedList.createListNode(arr)));
	}
}
