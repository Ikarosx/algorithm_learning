package leetcode.list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
 * @author Ikaros
 *
 */
public class N82 {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0), pre = dummy, cur = head;
		dummy.next = head;
		while (cur != null) {
			while (cur.next != null && cur.next.val == cur.val) {
				cur = cur.next;
			}
			if (pre.next == cur) {
				pre = pre.next;
			} else {
				pre.next = cur.next;
			}
			cur = cur.next;
		}

		return dummy.next;
	}

	public static ListNode deleteDuplicatesSorted(ListNode head) {

		Queue<ListNode> queue = new LinkedList<ListNode>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		ListNode temp = head;
		while (temp != null) {
			queue.add(temp);
			if (map.containsKey(temp.val)) {
				map.put(temp.val, map.get(temp.val) + 1);
			} else {
				map.put(temp.val, 1);
			}
			temp = temp.next;
		}
		temp = new ListNode(0);
		ListNode temp1 = temp;
		while (!queue.isEmpty()) {
			ListNode poll = queue.poll();
			poll.next = null;
			if (map.get(poll.val) <= 1) {
				temp.next = poll;
				temp = poll;
			}
		}
		return temp1.next;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2 };
		MyLinkedList.printList(deleteDuplicates(MyLinkedList.createListNode(arr)));
	}
}
