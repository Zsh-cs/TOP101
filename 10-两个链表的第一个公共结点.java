import java.util.*;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        int size1=0,size2=0;

        // 首先计算出两个链表的长度差
        while(p1!=null){
            p1=p1.next;
            size1++;
        }
        while(p2!=null){
            p2=p2.next;
            size2++;
        }

        // 让较长的链表先走diff步
        int diff;
        p1=pHead1;
        p2=pHead2;
        if(size1>size2){
            diff=size1-size2;
            p1=moveDiff(p1,diff);
        }else{
            diff=size2-size1;
            p2=moveDiff(p2,diff);
        }

        // 然后两个链表同时移动，相遇的结点就是第一个公共结点
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }

    public ListNode moveDiff(ListNode p, int diff){
        for(int i=0;i<diff;i++){
            p=p.next;
        }
        return p;
    }
}





