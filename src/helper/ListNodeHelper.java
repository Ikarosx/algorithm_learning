package helper;

import 剑指offer.ListNode;

/**
 * @author Ikarosx
 * @date 2020/7/12 21:42
 */
public class ListNodeHelper {
    public static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }
    
    public static ListNode generateListNodeByArray(int[] array) {
        assert array != null && array.length > 0;
        ListNode head = new ListNode(array[0]);
        ListNode result = head;
        for (int i = 1; i < array.length; i++) {
            head.next = new ListNode(array[i]);
            head = head.next;
        }
        return result;
    }
}
