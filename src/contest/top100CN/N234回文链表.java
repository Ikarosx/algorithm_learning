package contest.top100CN;

import 剑指offer.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author Ikarosx
 * @date 2020/7/15 8:29
 */
public class N234回文链表 {
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        if (head == null) {
            return true;
        }
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int size = list.size();
        for (int i = 0; i <= (size / 2); i++) {
            if (list.get(i).val != list.get(size - i - 1).val) {
                return false;
            }
        }
        return true;
    }
}
