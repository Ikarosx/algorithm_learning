package leetcode.周赛.w223;

import org.junit.Test;
import 剑指offer.ListNode;

/**
 * 给你链表的头节点 head 和一个整数 k 。
 *
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 * 示例 3：
 *
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 示例 4：
 *
 * 输入：head = [1,2], k = 1
 * 输出：[2,1]
 * 示例 5：
 *
 * 输入：head = [1,2,3], k = 2
 * 输出：[1,2,3]
 *
 *
 * 提示：
 *
 * 链表中节点的数目是 n
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 *
 * @author Ikarosx
 * @date 2021/1/10 10:33
 */
public class N5625交换链表中的节点 {

    @Test
    public void test() {
        System.out.println(swapNodes(new ListNode(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5}), 5));
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode v1 = head;
        ListNode v2 = head;
        ListNode v3;
        // 双指针先走
        for (int i = 1; i < k; i++) {
            v2 = v2.next;
        }
        // 第k个
        v3 = v2;
        while (v2.next != null) {
            v2 = v2.next;
            v1 = v1.next;
        }
        int temp = v3.val;
        v3.val = v1.val;
        v1.val = temp;
        return head;
    }
}
