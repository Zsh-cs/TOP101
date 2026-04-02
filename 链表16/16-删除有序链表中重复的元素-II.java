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
        // 表头不确定，建议创建虚拟头结点
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;

        while(prev!=null && prev.next!=null && prev.next.next!=null){
            // 只有下下一个节点的值不等于下一个节点的值，才移动prev
            if(prev.next.next.val!=prev.next.val){
                prev=prev.next;
            }else{
                // 否则，记住下一个节点的值，移动temp指针直到不重复节点
                int target=prev.next.val;
                ListNode temp=prev.next;
                while(temp!=null && temp.val==target){
                    temp=temp.next;
                }
                prev.next=temp;
            }
        }

        return dummy.next;
    }
}


