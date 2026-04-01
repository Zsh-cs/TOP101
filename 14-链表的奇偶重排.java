import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode oddEvenList (ListNode head) {
        // 只有0个、1个或2个结点的单链表无需奇偶重排
        if(head==null || head.next==null || head.next.next==null){
            return head;
        }

        ListNode odd=head;// odd指向奇数链表的头
        ListNode even=head.next;// even指向偶数链表的头
        ListNode evenHead=head.next;// 记住偶数链表的头，以便最终将奇数链表和偶数链表连接在一起

        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;       
    }
}




