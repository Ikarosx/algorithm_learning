package leetcode.序号.n200;

import 剑指offer.ListNode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 示例 1：
 * <img style="width: 500px; height: 142px;" src="https://assets.leetcode.com/uploads/2021/03/06/removelinked-list.jpg" alt="">
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 列表中的节点在范围 [0, 10<sup>4</sup>] 内
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 * <p>
 * <p>
 * 相关标签：
 * 链表
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @author Ikarosx
 * @date 2021/4/26
 */
public class N203移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
    	// 哨兵结点
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        ListNode pre = listNode;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return listNode.next;
    }
}