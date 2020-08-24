package leetcode.剑指offer.N21_40;

import helper.ListNodeHelper;
import org.junit.Test;
import 剑指offer.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * @author Ikarosx
 * @date 2020/8/24 16:43
 */
public class N25合并两个排序的链表 {

    @Test
    public void test() {
        ListNode l1 = ListNodeHelper.generateListNodeByArray(new int[]{1, 3, 5});
        ListNode l2 = ListNodeHelper.generateListNodeByArray(new int[]{0, 2, 4, 6});
        ListNodeHelper.print(mergeTwoLists(l1, l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 原地排序
        // 如果一方为空直接返回另一方
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 让小数为l1
        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        // 虚拟头结点
        ListNode head = new ListNode(-1);
        // 头结点指向l1
        head.next = l1;
        ListNode pre = head;
        // 遍历判断l2
        while (l2 != null) {
            // 如果l1已经是最后一个元素，直接将l2接进来
            if (l1.next == null) {
                l1.next = l2;
                break;
            }

            if (l2.val < l1.val) {
                // 如果l2值小于l1
                // 让pre结点指向l2
                pre.next = l2;
                // 记录l2链表的下一结点
                ListNode l2Next = l2.next;
                // 让l2指向l1
                l2.next = l1;
                // 更新l1为pre的下一个元素，防止l2Next会比当前数小但比上一个数大
                l1 = pre.next;
                l2 = l2Next;
            } else {
                // 遍历l1直到l1的值大于l2,同时更新pre
                while (l1 != null && l1.val <= l2.val) {
                    pre = pre.next;
                    l1 = l1.next;
                }
                // 跟上方一样的做法
                pre.next = l2;
                ListNode l2Next = l2.next;
                l2.next = l1;
                l1 = pre.next;
                l2 = l2Next;
            }
        }
        return head.next;
    }
}
