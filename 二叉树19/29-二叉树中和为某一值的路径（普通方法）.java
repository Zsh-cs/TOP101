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
     * @param sum int整型 
     * @return bool布尔型
     */
    public boolean hasPathSum (TreeNode root, int sum) {
        ArrayList<Integer> res=eachPathSum(root);
        for(Integer r: res){
            if(r==sum){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> eachPathSum(TreeNode root){
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        calculate(root,0,res);
        return res;
    }

    public void calculate(TreeNode node,int currentSum,ArrayList<Integer> res){
        if(node==null){
            return;
        }

        currentSum+=node.val;// 加上当前结点的值
        // 到达叶子结点
        if(node.left==null && node.right==null){
            // 把这条路径存起来
            res.add(currentSum);
            return;
        }

        calculate(node.left,currentSum,res);
        calculate(node.right,currentSum,res);
    }

}





