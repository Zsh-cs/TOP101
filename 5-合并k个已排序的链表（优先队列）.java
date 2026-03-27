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
     * @param lists ListNode类ArrayList 
     * @return ListNode类
     */
    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        if(lists==null || lists.size()==0){
            return null;
        }

        // 1.定义优先队列，指定比较规则为升序
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);

        // 2.把所有链表的头结点放进优先队列
        for(ListNode list : lists){
            if(list!=null){
                pq.add(list);
            }
        }

        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;

        // 3.只要队列不空，就一直取出队列中的最小元素
        while(!pq.isEmpty()){
            ListNode minNode=pq.poll();
            cur.next=minNode;
            cur=cur.next;

            // 如果这个结点后面还有人，就把接班人放进去继续排队
            if(minNode.next!=null){
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }
}






