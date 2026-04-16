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
     * @param root TreeNode类 
     * @param p int整型 
     * @param q int整型 
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // 保证代码的健壮性
        if(root==null){
            return -1;
        }
        
        // 从根结点出发
        // 如果p和q的值都小于当前结点的值，那么p和q都在当前结点的左子树里，往左走
        if(p<root.val && q<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        // 如果p和q的值都大于当前结点的值，那么p和q都在当前结点的右子树里，往右走
        if(p>root.val && q>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        // 其他情况下，当前结点就是最近公共祖先
        return root.val;
    }
}






