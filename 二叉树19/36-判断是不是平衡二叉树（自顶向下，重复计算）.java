import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param pRoot TreeNode类 
     * @return bool布尔型
     */
    public boolean IsBalanced_Solution (TreeNode pRoot) {
        // 1.成功基准条件
        if(pRoot==null){
            return true;
        }
        // 2.失败基准条件
        if(Math.abs(getDepth(pRoot.left)-getDepth(pRoot.right))>1){
            return false;
        }
        
        // 3.递归逻辑
        return IsBalanced_Solution(pRoot.left) && IsBalanced_Solution(pRoot.right);
    }

    // 求二叉树的深度
    public int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(getDepth(root.left),getDepth(root.right));
    }
}






