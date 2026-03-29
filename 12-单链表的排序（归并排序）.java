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
        // 边界条件
        if(head==null || head.next==null){
            return head;
        }

        // 先找到中间结点，然后把整个链表一分为二
        ListNode fast=head.next;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode right=slow.next;
        slow.next=null;// 关键：切断左右链表
        ListNode left=head;

        // 归并排序
        left=sortInList(left);
        right=sortInList(right);
        return merge(left,right);
    }

    // 合并两个有序链表
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;

        while(left!=null && right!=null){
            if(left.val<right.val){
                cur.next=left;
                left=left.next;
            }else{
                cur.next=right;
                right=right.next;
            }
            cur=cur.next;
        }

        if(left!=null){
            cur.next=left;
        }else{
            cur.next=right;
        }

        return dummy.next;
    }
}





