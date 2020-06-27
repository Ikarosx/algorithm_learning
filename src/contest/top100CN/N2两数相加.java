package contest.top100CN;

import 剑指offer.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author Ikaros
 * @date 2020/06/24 00:23
 */
public class N2两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // d存储进位
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int d = 0;
        while (l1 != null || l2 != null) {
            int sum = d;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            d = sum / 10;
        }
        if (d != 0) {
            temp.next = new ListNode(d);
        }
        return head.next;
    }
}
