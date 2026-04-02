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
        return divideAndConquer(lists,0,lists.size()-1);
    }

    // 分而治之：把lists中从left到right范围内的链表合并起来
    public ListNode divideAndConquer(ArrayList<ListNode> lists,int left,int right){
        // 边界条件：如果这部分只有一个链表，直接返回它
        if(left==right){
            return lists.get(left);
        }

        int mid=left+(right-left)/2;
        // 左半边外包出去，它会给我一个合并好的长链表
        ListNode list1=divideAndConquer(lists,left,mid);
        // 右半边外包出去，它也会给我一个合并好的长链表
        ListNode list2=divideAndConquer(lists,mid+1,right);
        // 最后，把这两个长链表两两合并
        return merge(list1,list2);
    } 

    public ListNode merge(ListNode p1,ListNode p2){
        if(p1==null) return p2;
        if(p2==null) return p1;

        if(p1.val<p2.val){
            p1.next=merge(p1.next,p2);
            return p1;
        }else{
            p2.next=merge(p1,p2.next);
            return p2;
        }
    }
}





