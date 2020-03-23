package simple;

import org.junit.jupiter.api.Test;

/** @Author: Ikaros @Date: 2020/1/11 10:57 */
public class DeleteDuplicates {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode tempNode = head;
    if (head == null || head.next == null) {
      return head;
    }
    while (head.next != null && head.next.val == tempNode.val) {
      head = head.next;
    }
    tempNode.next = deleteDuplicates(head.next);
    return tempNode;
  }

  @Test
  public void solution() {}

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
