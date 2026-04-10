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
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(pRoot==null){
            return res;
        }
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(pRoot);

        // 先正常层序遍历一遍
        while(!q.isEmpty()){
            ArrayList<Integer> row=new ArrayList<>();
            int rowSize=q.size();
            for(int i=0;i<rowSize;i++){
                TreeNode cur=q.poll();
                row.add(cur.val);
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
            // 然后把偶数层的row翻转一下
            if(res.size()%2==1){
                Collections.reverse(row);
            }
            res.add(row);
        }

        return res;
    }
}








