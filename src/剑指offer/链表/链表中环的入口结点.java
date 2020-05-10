package 剑指offer.链表;

import 剑指offer.ListNode;

import java.util.HashSet;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @author Ikaros
 * @date 2020/5/8 20:41
 */
public class 链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 还可以快慢指针
        HashSet<ListNode> set = new HashSet<>();
        while (pHead != null && set.add(pHead)) {
            pHead = pHead.next;
        }
        return pHead;
    }
}
