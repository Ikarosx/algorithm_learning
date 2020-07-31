package contest.top100CN;

import 剑指offer.ListNode;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * TODO
 *
 * @author Ikarosx
 * @date 2020/7/30 7:38
 */
public class N148排序链表 {
    public ListNode sortList(ListNode head) {
        // 归并
        // 为空或者只有一个结点直接返回
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        // 快慢指针找到中点位置
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // tmp是右边
        ListNode tmp = slow.next;
        // slow是左边部分最靠右的
        slow.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        // 合并的过程
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
    
}
