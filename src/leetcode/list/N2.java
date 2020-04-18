package leetcode.list;

/**
 * You are given two non-empty linked lists representing two
 * non-negative integers.
 * The digits are stored in reverse order and each of their
 * nodes contain a single digit. Add the two numbers and
 * return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading
 * zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author Ikaros
 */
public class N2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode last = head;
        while (l1 != null || l2 != null) {
            int a, b;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            } else {
                a = 0;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            } else {
                b = 0;
            }
            if (a + b >= 10) {
                if (l2 == null) {
                    l2 = new ListNode(0);
                }
                l2.val += (a + b) / 10;
            }
            last.next = new ListNode((a + b) % 10);
            last = last.next;
        }
        return head.next;
    }
    
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
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
        return tempListNode.next;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1};
        int[] arr2 = {9, 9};
        MyLinkedList.printList(addTwoNumbers(MyLinkedList.createListNode(arr1), MyLinkedList.createListNode(arr2)));
    }
}
