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

    private ArrayList<Integer> list=new ArrayList<>();
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param root TreeNode类 
     * @return bool布尔型
     */
    public boolean isValidBST (TreeNode root) {
        // 二叉搜索树的中序遍历有序
        inorderTraversal(root);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public void inorderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
}







