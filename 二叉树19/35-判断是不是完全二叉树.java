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
     * @return bool布尔型
     */
    public boolean isCompleteTree (TreeNode root) {
        // ArrayDeque不支持放入null
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        // 标记是否已经遇到了第一个空结点
        boolean flag=false;

        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur==null){
                // 遇到第一个空结点，之后不应该再有任何结点
                flag=true;
            }else{
                if(flag){
                    return false;
                }
                // 正常的层序遍历，不管是不是空结点都往里放
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return true;

    }

}





