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
     * @return int整型一维数组
     */
    public int[] inorderTraversal (TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(list,root);
        int[] res=new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }

    private void inorder(List<Integer> list,TreeNode root){
        // 中序遍历：左根右
        if(root==null){
            return;
        }

        inorder(list,root.left);
        list.add(root.val);
        inorder(list,root.right);
    }
}