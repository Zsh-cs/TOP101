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
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        // 尝试使用优先队列
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode cur=head;
        while(cur!=null){
            pq.add(cur);
            cur=cur.next;
        }

        head=pq.poll();
        cur=head;
        while(!pq.isEmpty()){
            ListNode minNode=pq.poll();
            cur.next=minNode;
            cur=minNode;
        }
        cur.next=null;// 避免原先next域的影响

        return head;
    }

}