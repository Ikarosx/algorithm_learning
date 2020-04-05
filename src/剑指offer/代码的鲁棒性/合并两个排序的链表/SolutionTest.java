package 剑指offer.代码的鲁棒性.合并两个排序的链表;

import org.junit.jupiter.api.Test;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表， 当然我们需要合成后的链表满足单调不减规则。
 *
 * @author Ikaros
 * @date 2020/03/12 11:00
 */
class SolutionTest {
  public ListNode Merge(ListNode list1, ListNode list2) {
    ListNode before = new ListNode(-1);
    ListNode head = before;
    before.next = list1;
    // 135 468
    while (list2 != null) {
      if (list2.val >= list1.val) {
        before = list1;
        list1 = list1.next;
        if (list1 == null) {
          before.next = list2;
          break;
        }
      } else {
        before.next = list2;
        before = list2;
        list2 = list2.next;
        before.next = list1;
      }
    }
    return head.next;
  }

  @Test
  void solution() {
    long l = System.currentTimeMillis();
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(3);
    ListNode listNode3 = new ListNode(5);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    ListNode listNode4 = new ListNode(4);
    ListNode listNode5 = new ListNode(6);
    ListNode listNode6 = new ListNode(8);
    listNode4.next = listNode5;
    listNode5.next = listNode6;
    ListNode listNode = Merge(listNode1, listNode4);
    long l1 = System.currentTimeMillis();
    System.out.println(l1 - l);
  }
}
