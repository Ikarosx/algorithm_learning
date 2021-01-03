package leetcode.sign;

import 剑指offer.ListNode;

/**
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 * 通过次数63,236提交次数104,779
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ikarosx
 * @date 2021/1/3 0:02
 */
public class N86分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode listNodeL = new ListNode(-1);
        ListNode lt = listNodeL;
        ListNode listNodeG = new ListNode(-1);
        ListNode lg = listNodeG;
        while (head != null) {
            if (head.val < x) {
                listNodeL.next = head;
                listNodeL = listNodeL.next;
            } else {
                listNodeG.next = head;
                listNodeG = listNodeG.next;
            }
            head = head.next;
        }
        listNodeL.next = null;
        listNodeG.next = null;
        listNodeL.next = lg.next;
        return lt.next;
    }
}
