package leetcode.剑指offer.N1_20;

import helper.ListNodeHelper;
import org.junit.Test;
import 剑指offer.ListNode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * @author Ikarosx
 * @date 2020/8/23 9:07
 */
public class N18删除链表的节点 {

    @Test
    public void test() {
        ListNode listNode = ListNodeHelper.generateListNodeByArray(new int[]{5});
        listNode = deleteNode(listNode, 5);
        ListNodeHelper.print(listNode);
    }

    public ListNode deleteNode(ListNode head, int val) {
        // 虚拟结点
        ListNode first = new ListNode(-1);
        // 虚拟结点指向头
        first.next = head;
        // 前指针
        ListNode pre = first;
        // 当前指针
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                // 如果当前指针指向值与要删除值相同
                // 前指针的next指向当前指针的next
                pre.next = current.next;
            } else {
                // 如果值不同，更新前指针为当前指针
                pre = current;
            }
            // 更新当前指针为下一指针
            current = current.next;
        }
        return first.next;
    }

}
