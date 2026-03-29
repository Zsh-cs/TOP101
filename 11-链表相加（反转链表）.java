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
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // 先反转这两个链表，使之末尾对齐
        head1=reverseList(head1);
        head2=reverseList(head2);

        ListNode p1=head1;
        ListNode p2=head2;

        // 采用头插法创建新链表
        ListNode newHead=null;
        int carry=0;// 进位，默认为0
        int val1,val2,sum;
        while(p1!=null || p2!=null || carry!=0){
            val1= (p1!=null) ? p1.val : 0;
            val2= (p2!=null) ? p2.val : 0;
            sum=val1+val2+carry;
            carry=sum/10;// 更新进位
            
            ListNode newNode=new ListNode(sum%10);// 对10取余
            newNode.next=newHead;
            newHead=newNode;
            if(p1!=null){
                p1=p1.next;
            }
            if(p2!=null){
                p2=p2.next;
            }
        }   
        
        return newHead;
    }

    // 反转链表
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






