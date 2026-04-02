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
     * @param pHead1 ListNode类 
     * @param pHead2 ListNode类 
     * @return ListNode类
     */
    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        // 虚拟头结点
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;

        // 以下两行代码只是为了便于理解，避免因命名带来的混淆
        ListNode p1=pHead1;
        ListNode p2=pHead2;

        // 当两个链表都不为空时，进入循环比较
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                cur.next=p1;
                p1=p1.next;
            }else{
                cur.next=p2;
                p2=p2.next;
            }
            cur=cur.next;
        }

        // 如果其中一个链表走完了，直接接上另一个链表的剩余部分
        if(p1!=null){
            cur.next=p1;
        }else{
            cur.next=p2;
        }

        // 返回真正头结点
        return dummy.next;
    }
}






