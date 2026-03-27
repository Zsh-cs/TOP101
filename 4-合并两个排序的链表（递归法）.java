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
        ListNode p1=pHead1;
        ListNode p2=pHead2;

        // 1.边界条件
        if(p1==null){
            return p2;
        }
        if(p2==null){
            return p1;
        }

        // 2.递归比较
        if(p1.val<p2.val){
            p1.next=Merge(p1.next,p2);
            return p1;
        }else{
            p2.next=Merge(p1,p2.next);
            return p2;
        }
    }
}



