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
     * @param preOrder int整型一维数组 
     * @param vinOrder int整型一维数组 
     * @return TreeNode类
     */
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        if(preOrder.length==0 || vinOrder.length==0){
            return null;
        }
        TreeNode root=new TreeNode(preOrder[0]);
        for(int i=0;i<vinOrder.length;i++){
            if(vinOrder[i]==preOrder[0]){
                root.left=reConstructBinaryTree(
                    Arrays.copyOfRange(preOrder,1,i+1),
                    Arrays.copyOfRange(vinOrder,0,i));
                root.right=reConstructBinaryTree(
                    Arrays.copyOfRange(preOrder,i+1,preOrder.length),
                    Arrays.copyOfRange(vinOrder,i+1,vinOrder.length));
                break;
            }
        }
        return root;
    }
}





