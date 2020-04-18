package leetcode.list;

/**
 * Given a linked list and a value x,
 * partition it such that all nodes less than x come before
 * nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the
 * nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 * @author Ikaros
 */
public class N86 {
    public static ListNode partition(ListNode head, int x) {
        
        ListNode less = new ListNode(0), greater = new ListNode(0), cur = head, a = less, b = greater;
        while (cur != null) {
            ListNode temp = cur;
            if (cur.val < x) {
                less.next = cur;
                less = cur;
            } else {
                greater.next = cur;
                greater = cur;
            }
            cur = temp.next;
            temp.next = null;
        }
        less.next = b.next;
        return a.next;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5, 2};
        ListNode reverseList = partition(MyLinkedList.createListNode(arr), 3);
        MyLinkedList.printList(reverseList);
    }
}
