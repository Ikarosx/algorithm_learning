package contest.top100;

import 剑指offer.ListNode;

/**
 * @author Ikaros
 * @date 2020/6/1 12:36
 */
public class N148SortList {
    /**
     * 链表快排
     *
     * @param head
     *
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //Define less list, equal list, more list
        ListNode pivot = head;
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        
        ListNode l = less;
        ListNode p = pivot;
        ListNode m = more;
        //tranverse list using cur pointer
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val < pivot.val) {
                l.next = cur;
                l = l.next;
            } else if (cur.val == pivot.val) {
                p.next = cur;
                p = p.next;
            } else {
                m.next = cur;
                m = m.next;
            }
            cur = cur.next;
        }
        //recursively sort left and right part of list
        //less -> null, pivot -> null, more -> null
        p.next = null;
        l.next = null;
        m.next = null;
        ListNode lessSorted = sortList(less.next);
        ListNode moreSorted = sortList(more.next);
        //append less, pivot, more together to get result
        if(lessSorted != null){     //less sorted is not null, less->pivot->more->null
            l = lessSorted;
            while(l.next!=null){
                l = l.next;
            }
        
            l.next = pivot;
            p.next = moreSorted;
            return lessSorted;
        
        }else{                       //pivot -> more -> null
        
            p.next = moreSorted;
            return pivot;
        }
    }
  
}
