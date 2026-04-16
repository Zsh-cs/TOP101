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
     * @param o1 int整型 
     * @param o2 int整型 
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // 自底向上递归
        // 1.边界条件
        if(root==null){
            return -1;
        }
        if(root.val==o1 || root.val==o2){
            return root.val;
        }

        // 2.递归逻辑
        int leftResult=lowestCommonAncestor(root.left,o1,o2);
        int rightResult=lowestCommonAncestor(root.right,o1,o2);
        if(leftResult!=-1 && rightResult!=-1){// p在一边，q在另一边
            return root.val;// 那么当前结点是最近公共祖先
        } else if(leftResult==-1){// p、q都在右边
            return rightResult;// 把右边的结果往上传
        } else{// p、q都在左边
            return leftResult;// 把左边的结果往上传
        }
    }

}






