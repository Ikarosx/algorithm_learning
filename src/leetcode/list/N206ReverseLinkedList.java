package leetcode.list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class N206ReverseLinkedList {
	public static ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode current = head;
		ListNode next;
		while (current != null) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		return pre;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(4);
		a.next = a1;
		a1.next = a2;
		a2.next = a3;
		ListNode reverseList = reverseList(a);
		while (reverseList != null) {
			System.out.println(reverseList.val);
			reverseList = reverseList.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
