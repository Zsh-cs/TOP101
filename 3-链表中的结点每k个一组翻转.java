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
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // 虚拟头结点
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;

        while(true){
            // 从check开始遍历k次，如果中途遇到null，说明不足k个，直接返回dummy.next
            ListNode check=prev;
            for(int i=0;i<k;i++){
                check=check.next;
                if(check==null){
                    return dummy.next;
                }
            }

            // 翻转当前k个结点
            ListNode groupPrev=null;
            ListNode groupCur=prev.next;
            ListNode groupTemp=null;
            for(int i=0;i<k;i++){
                groupTemp=groupCur.next;
                groupCur.next=groupPrev;
                groupPrev=groupCur;
                groupCur=groupTemp;
            }

            // 连接翻转后的组
            ListNode groupTail=prev.next;// 翻转后当前组的尾结点
            ListNode groupHead=groupPrev;// 翻转后当前组的头结点
            ListNode nextGroup=groupCur;// 下一组的第一个结点
            prev.next=groupHead;
            groupTail.next=nextGroup;

            // 更新prev，准备处理下一组
            prev=groupTail;     
        }
    }
}