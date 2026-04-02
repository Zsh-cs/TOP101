import java.util.*;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }

        // 快慢指针法
        ListNode fast=head;
        ListNode slow=head;

        // 如果写成while(fast!=null){}，会报错，
        // 因为如果fast!=null，但fast.next==null，
        // 那么执行fast=fast.next.next这行代码就会出错
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;// 走2步
            slow=slow.next;// 走1步

            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}