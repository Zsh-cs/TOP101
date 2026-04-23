import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 求二叉树的右视图
     * @param preOrder int整型一维数组 先序遍历
     * @param inOrder int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve (int[] preOrder, int[] inOrder) {
        TreeNode root=reconstruct(preOrder,inOrder);
        // 层序遍历，每层取最后一个即得右视图
        ArrayList<Integer> res=new ArrayList<>();
        LinkedList<TreeNode> q=new LinkedList<>();

        if(root==null){
            return new int[0];
        }
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
                if(i==size-1){
                    res.add(cur.val);
                }
            }
        }
        
        int[] view=new int[res.size()];
        for(int i=0;i<view.length;i++){
            view[i]=res.get(i);
        }
        return view;
    }

    public TreeNode reconstruct(int[] preOrder,int[] inOrder){
        if(preOrder.length==0 || inOrder.length==0){
            return null;
        }
        TreeNode root=new TreeNode(preOrder[0]);
        for(int i=0;i<inOrder.length;i++){
            if(inOrder[i]==preOrder[0]){
                root.left=reconstruct(
                    Arrays.copyOfRange(preOrder,1,i+1),
                    Arrays.copyOfRange(inOrder,0,i)
                );
                root.right=reconstruct(
                    Arrays.copyOfRange(preOrder,i+1,preOrder.length),
                    Arrays.copyOfRange(inOrder,i+1,inOrder.length)
                );
                break;
            }
        }
        return root;
    }
}