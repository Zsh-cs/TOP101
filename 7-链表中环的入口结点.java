import java.util.*;
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast=pHead;
        ListNode slow=pHead;

        // 1.让快慢指针先在环内相遇
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            // 2.相遇后，把其中一个指针如fast指针扔回链表起点，另一个原地不动
            if(fast==slow){
                fast=pHead;
                // 3.让它们以相同速度移动，直到相遇
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return fast;// 相遇点就是环的入口结点
            }
        }
        return null;
    }
}



