package leetcode.list;

public class MyLinkedList {
	public static ListNode createListNode(int arr[]) {
		int n = arr.length;
		if (n == 0) {
			return null;
		}
		ListNode head = new ListNode(arr[0]);
		ListNode cur = head;
		for (int i = 1; i < n; i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
		return head;
	}

	public static void printList(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + "->");
			cur = cur.next;
		}
		System.out.print("NULL");
	}

	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null, cur = head, next;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
