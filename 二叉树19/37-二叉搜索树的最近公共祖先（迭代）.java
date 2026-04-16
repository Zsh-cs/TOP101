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

        // 迭代法
        while(root!=null){
            if(p<root.val && q<root.val){
                root=root.left;
            } else if(p>root.val && q>root.val){
                root=root.right;
            } else{
                return root.val;
            }
        }
        return -1;
    }
}






