package leetcode.list;

/**
 * Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 * @author Ikaros
 *
 */
public class N234 {
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode dummy = new ListNode(0), cur = head, mid = head, cur1;
		dummy.next = head;
		while (cur.next != null && cur.next.next != null) {
			mid = mid.next;
			cur = cur.next.next;
		}
		cur = mid.next;
		cur1 = head;
		ListNode reverseList = MyLinkedList.reverseList(cur);
		while (cur1 != null && reverseList != null) {
			if (reverseList.val != cur1.val) {
				return false;
			}
			reverseList = reverseList.next;
			cur1 = cur1.next;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 1 };
		System.out.println(isPalindrome(MyLinkedList.createListNode(arr)));
	}
}
