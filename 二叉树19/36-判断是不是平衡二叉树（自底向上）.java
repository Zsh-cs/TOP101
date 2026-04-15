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
        return getDepth(pRoot)!=-1;
    }

    // 求二叉树的深度
    public int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
    
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        // 左子树或右子树内部已经不平衡了，直接向上传-1
        // 左右子树各自平衡，但凑在一起不平衡，也传-1
        if(left==-1 || right==-1 || Math.abs(left-right)>1){
            return -1;
        }

        // 其他情况返回树的真实高度
        return 1+Math.max(getDepth(root.left),getDepth(root.right));
    }
}






