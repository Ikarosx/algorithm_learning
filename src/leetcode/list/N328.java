package leetcode.list;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
 * @author Ikaros
 *
 */
public class N328 {
	public static ListNode oddEvenList(ListNode head) {
		ListNode odd = new ListNode(0), even = new ListNode(0), cur = head, a = odd, b = even;
		int count = 1;
		while (cur != null) {
			ListNode temp = cur;
			if (count++ % 2 == 1) {
				odd.next = cur;
				odd = cur;
			} else {
				even.next = cur;
				even = cur;
			}
			cur = temp.next;
			temp.next = null;
		}
		odd.next = b.next;
		return a.next;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 3, 5, 6, 4, 7 };
		ListNode reverseList = oddEvenList(MyLinkedList.createListNode(arr));
		MyLinkedList.printList(reverseList);
	}
}
