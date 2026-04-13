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
     * @param t1 TreeNode类 
     * @param t2 TreeNode类 
     * @return TreeNode类
     */
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // 1.边界条件
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        if(t1==null && t2==null){
            return null;
        }

        // 2.递归逻辑
        t1.val+=t2.val;
        t1.left=mergeTrees(t1.left,t2.left);// 外包给左边
        t1.right=mergeTrees(t1.right,t2.right);// 外包给右边
        return t1;
    }
}





