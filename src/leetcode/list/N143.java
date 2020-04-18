package leetcode.list;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * @author Ikaros
 *
 */
public class N143 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		reorderList(MyLinkedList.createListNode(arr));
	}

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode dummy = new ListNode(0), cur = head, mid = head, pre = dummy, temp, temp1;
		dummy.next = head;
		int i = 0;
		while (cur.next != null) {
			cur = cur.next;
			i++;
			i %= 2;
			if (i == 1) {
				mid = mid.next;
				pre = pre.next;
			}
		}
		cur = head;
		pre.next = null;
		ListNode reverse = reverse(mid);
		while (cur != null && reverse != null) {
			temp = cur.next;
			temp1 = reverse.next;
			cur.next = reverse;
			reverse.next = temp;
			if (temp == null && temp1 != null) {
				reverse.next = temp1;
				head = dummy.next;
				return;
			}
			reverse = temp1;
			cur = temp;

		}
	}

	private static ListNode reverse(ListNode mid) {
		ListNode pre = null, cur = mid, next;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

}
