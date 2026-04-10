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
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // 队列
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            ArrayList<Integer> row=new ArrayList<>();
            int rowSize=queue.size();
            for(int i=0;i<rowSize;i++){
                TreeNode cur=queue.poll();
                row.add(cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            res.add(row);
        }
        return res;
    }
}






