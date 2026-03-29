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
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // 辅助栈法
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();

        ListNode p1=head1;
        ListNode p2=head2;
        // 将链表数据压入栈中
        while(p1!=null){
            s1.push(p1.val);
            p1=p1.next;
        }
        while(p2!=null){
            s2.push(p2.val);
            p2=p2.next;
        }

        // 开始弹出并计算，使用头插法创建新结点
        ListNode newHead=null;
        int carry=0;
        int val1,val2,sum;
        while(!s1.isEmpty() || !s2.isEmpty() || carry!=0){
            val1= (!s1.isEmpty()) ? s1.pop() : 0;
            val2= (!s2.isEmpty()) ? s2.pop() : 0;
            sum=val1+val2+carry;
            carry=sum/10;

            ListNode newNode=new ListNode(sum%10);
            newNode.next=newHead;
            newHead=newNode;
        }

        return newHead;
    }
}






