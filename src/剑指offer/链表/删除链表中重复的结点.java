package 剑指offer.链表;

import org.junit.jupiter.api.Test;
import 剑指offer.ListNode;
import 剑指offer.ListNodeUtils;

/**
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @author Ikaros
 * @date 2020/5/8 20:53
 */
public class 删除链表中重复的结点 {
    @Test
    public void test() {
        ListNode listNode = ListNodeUtils.generateListNodeByArray(new int[]{});
        ListNodeUtils.printListNode(deleteDuplication(null));
    }
    
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode pre = new ListNode(pHead.val - 1);
        ListNode head = pre;
        while (pHead != null) {
            // 判断是否不重复
            boolean flag = false;
            while (pHead.next != null && pHead.next.val == pHead.val) {
                flag = true;
                pHead = pHead.next;
            }
            if (flag) {
                pre.next = pHead.next;
                pHead = pHead.next;
            } else {
                pre.next = pHead;
                pre = pHead;
                pHead = pHead.next;
            }
        }
        return head.next;
    }
}
