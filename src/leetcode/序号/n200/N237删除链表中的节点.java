package leetcode.序号.n200;

import 剑指offer.ListNode;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 * <p>
 * 现有一个链表 --&nbsp;head =&nbsp;[4,5,1,9]，它可以表示为:
 *
 * <img style="height: 49px; width: 300px;" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/01/19/237_example.png" alt="">
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为&nbsp;5&nbsp;的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：给定你链表中值为&nbsp;1&nbsp;的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 提示：
 * <p>
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 * <p>
 * <p>
 * 相关标签：
 * 链表
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * @author Ikarosx
 * @date 2021/4/29
 */
public class N237删除链表中的节点 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}