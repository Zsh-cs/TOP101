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
     * @return TreeNode类
     */
    public TreeNode Mirror (TreeNode pRoot) {
        // 1.边界条件
        if(pRoot==null){
            return null;
        }

        // 2.递归逻辑
        TreeNode temp=pRoot.left;
        pRoot.left=pRoot.right;
        pRoot.right=temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}







