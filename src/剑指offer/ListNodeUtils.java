package 剑指offer;

/**
 * @author Ikaros
 * @date 2020/5/8 21:36
 */
public class ListNodeUtils {
    public static ListNode generateListNodeByArray(int[] array) {
        ListNode listNode = new ListNode(array[0]);
        ListNode result = listNode;
        for (int i = 1; i < array.length; i++) {
            ListNode listNode1 = new ListNode(array[i]);
            listNode.next = listNode1;
            listNode = listNode1;
        }
        return result;
    }
    
    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next == null ? "" : " -> "));
            node = node.next;
        }
        System.out.println();
    }
}
