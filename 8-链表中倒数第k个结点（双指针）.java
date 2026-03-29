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
     * @param pHead ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // 双指针法（尺子法）

        // 1.定义两个指针，最初都指向头结点
        ListNode fast=pHead;
        ListNode slow=pHead;

        // 2.先让fast移动k步
        for(int i=0;i<k;i++){
            // 如果还没走够k步，fast==null，说明链表长度不足k，返回null
            if(fast==null){
                return null;
            }
            fast=fast.next;
        }
        
        // 3.让fast和slow同时移动，每次都只走1步，模拟一把长度为k的尺子
        // 当fast==null时，说明尺子碰到了墙壁，这时slow指向的就是倒数第k个结点
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;

    }
}



