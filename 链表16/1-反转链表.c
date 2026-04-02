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
 * @return ListNode类
 */
struct ListNode* ReverseList(struct ListNode* head ) {
    // write code here
    struct ListNode* pre=NULL;
    struct ListNode* p=head;
    while(p){
        struct ListNode* temp=p->next;
        p->next=pre;
        pre=p;
        p=temp;
    }
    return pre;
}