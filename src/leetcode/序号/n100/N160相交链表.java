package leetcode.序号.n100;

import 剑指offer.ListNode;

/**
 * 给你两个单链表的头节点&nbsp;headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 *
 * <a href="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png"><img style="height: 130px; width: 400px;" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png" alt=""></a>
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>
 * 示例 1：
 *
 * <a href="https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png"><img style="height: 130px; width: 400px;" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_1.png" alt=""></a>
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 示例&nbsp;2：
 *
 * <a href="https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png"><img style="height: 136px; width: 350px;" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_2.png" alt=""></a>
 * <p>
 * 输入：intersectVal&nbsp;= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <p>
 * 示例&nbsp;3：
 *
 * <a href="https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png"><img style="height: 126px; width: 200px;" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_3.png" alt=""></a>
 * <p>
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 * <p>
 * 提示：
 * <p>
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 10<sup>4</sup>
 * 1 <= Node.val <= 10<sup>5</sup>
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 * <p>
 * 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
 * <p>
 * 相关标签：
 * 链表
 * <p>
 * 原题地址：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author Ikarosx
 * @date 2021/6/4
 */
public class N160相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 长度不同的时候如果为null则指向另一个链表
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null || tempB != null) {
            if (tempA == null) {
                tempA = headB;
            }
            if (tempB == null) {
                tempB = headA;
            }
            if (tempA == tempB) {
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}