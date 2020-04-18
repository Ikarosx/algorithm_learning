package leetcode.list;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 * @author Ikaros
 *
 */
public class N445 {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1 = reverseList(l1);
		l2 = reverseList(l2);
		ListNode node = new ListNode(0);
		ListNode tempListNode = node;
		int flag = 0;
		while (l1 != null || l2 != null || flag != 0) {
			int v = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + flag;
			flag = v / 10;
			v %= 10;
			node.next = new ListNode(v);
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
			node = node.next;
		}
		return reverseList(tempListNode.next);
	}

	public static ListNode reverseList(ListNode head) {

		ListNode pre = null, cur = head, next;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	public static void main(String[] args) {
		int[] arr1 = { 3, 4, 2 };
		int[] arr2 = { 4, 6, 5 };
		MyLinkedList.printList(addTwoNumbers(MyLinkedList.createListNode(arr1), MyLinkedList.createListNode(arr2)));
	}
}
