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
     * @param m int整型 
     * @param n int整型 
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // 虚拟头结点，必须初始化，不能=null，否则dummy.next非法
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=head;
        ListNode prev=dummy;

        // 先将prev移动到m前面那个结点
        for(int i=0;i<m-1;i++){
            prev=prev.next;
        }
        // cur指向m对应的结点
        cur=prev.next;

        // 头插法
        for(int i=0;i<n-m;i++){
            ListNode temp=cur.next;
            cur.next=temp.next;
            temp.next=prev.next;
            prev.next=temp;
        }

        return dummy.next;
    }
}




