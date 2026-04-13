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
    public boolean isSymmetrical (TreeNode pRoot) {
        // 左子树的左孩子对应右子树的右孩子
        // 左子树的右孩子对应右子树的左孩子
        if(pRoot==null){
            return true;
        }
        return check(pRoot.left,pRoot.right);
    }

    public boolean check(TreeNode left,TreeNode right){
        // 1.边界条件
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null || left.val!=right.val){
            return false;
        }

        // 2.递归逻辑
        return check(left.left,right.right) && check(left.right,right.left);
    }
}




