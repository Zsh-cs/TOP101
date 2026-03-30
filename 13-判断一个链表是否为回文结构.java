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
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail (ListNode head) {
        if(head==null || head.next==null){
            return true;
        } 

        // 从中间将链表一分为二
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second=slow.next;
        slow.next=null;

        // 反转第二条链表
        second=reverseList(second);
        ListNode first=head;
        while(first!=null && second!=null){
            if(first.val!=second.val){
                return false;
            }
            first=first.next;
            second=second.next;
        }
        return true;

    }

    public ListNode reverseList(ListNode head){
        ListNode cur=head;
        ListNode prev=null;
        ListNode temp=null;

        while(cur!=null){
            temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
}






