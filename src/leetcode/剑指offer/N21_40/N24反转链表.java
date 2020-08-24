package leetcode.剑指offer.N21_40;

import helper.ListNodeHelper;
import org.junit.Test;
import 剑指offer.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * @author Ikarosx
 * @date 2020/8/24 16:25
 */
public class N24反转链表 {

    @Test
    public void test() {
        ListNode listNode = ListNodeHelper.generateListNodeByArray(new int[]{1, 2, 3, 4});
        ListNodeHelper.print(reverseList(listNode));
    }

    public ListNode reverseList(ListNode head) {
        // 递归
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }
}
