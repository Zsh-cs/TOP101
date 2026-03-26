/**
 * struct ListNode {
 *	int val;
 *	struct ListNode *next;
 * };
 */
/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * 
 * @param head ListNode类 
 * @param m int整型 
 * @param n int整型 
 * @return ListNode类
 */
#include <math.h>
typedef struct ListNode ListNode;
ListNode* reverseBetween(ListNode* head, int m, int n) {
    // 创建虚拟头结点，让m=1和m=2,3,...这两种情况能够统一处理
    ListNode dummy;
    dummy.next=head;
    ListNode* prev=&dummy;

    // 让prev走到m前一个结点
    for(int i=0;i<m-1;i++){
        prev=prev->next;
    }
    // cur指向m结点
    ListNode* cur=prev->next;

    // 把区间内m后面的结点，逐个头插到prev后面（头插法）
    for(int i=0;i<n-m;i++){
        ListNode* temp=cur->next;
        cur->next=temp->next;
        temp->next=prev->next;// 此处写temp->next=cur是错的，因为cur是死的，一直指向m结点
        prev->next=temp;
    }
    return dummy.next;
}






