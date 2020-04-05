package 剑指offer.链表.从尾到头打印链表;

import org.junit.jupiter.api.Test;
import 剑指offer.ListNode;

import java.util.ArrayList;
import java.util.Random;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 *
 * @author Ikaros
 * @date 2020/03/07 10:31
 */
class SolutionTest {
    ArrayList<Integer> list = new ArrayList<>();
    
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //    Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
            //      stack.push(listNode.val);
            //      listNode = listNode.next;
        }
        //    while (!stack.empty()) {
        //      list.add(stack.pop());
        //    }
        //    if (listNode != null) {
        //      printListFromTailToHead(listNode.next);
        //      list.add(listNode.val);
        //    }
        return list;
    }
    
    @Test
    void solution() {
        long l = System.currentTimeMillis();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        Random random = new Random(System.currentTimeMillis());
        for (int i = 2; i < 1000000; i++) {
            temp.next = new ListNode(random.nextInt());
            temp = temp.next;
        }
        ArrayList<Integer> list = printListFromTailToHead(head);
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
