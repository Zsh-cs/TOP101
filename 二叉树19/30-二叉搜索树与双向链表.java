import java.util.*;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {

    private TreeNode head=null;
    private TreeNode prev=null;// 中序遍历的上一个结点

    public TreeNode Convert(TreeNode pRootOfTree) {
        // 中序遍历：左根右
        if(pRootOfTree==null){
            return null;
        }
        Convert(pRootOfTree.left);
        if(prev==null){
            head=pRootOfTree;// 此时是第一次到达最左下的节点，它就是链表头
            prev=pRootOfTree;
        }else{
            prev.right=pRootOfTree;
            pRootOfTree.left=prev;
            prev=pRootOfTree;
        }  
        Convert(pRootOfTree.right);
        return head;
    }
}





