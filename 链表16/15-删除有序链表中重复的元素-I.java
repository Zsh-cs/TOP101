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
    public ListNode deleteDuplicates (ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode cur=head;
        while(cur!=null && cur.next!=null){
            // 只有在下个元素的值与当前元素的值不一样时，才移动cur
            if(cur.next.val!=cur.val){
                cur=cur.next;
            }else{// 否则直接跳过cur.next
                ListNode temp=cur.next.next;
                cur.next.next=null;// 清空cur.next的next域
                cur.next=temp;
            }
        }
        return head;
    }
}






