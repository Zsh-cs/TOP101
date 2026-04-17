import java.util.*;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    private int index=0;

    String Serialize(TreeNode root) {
        ArrayList<String> list=new ArrayList<>();
        preorder(root,list);
        return String.join(",",list);
    }

    TreeNode Deserialize(String str) {
        this.index=0;// 重置索引，线程安全
        String[] values=str.split(",");
        return build(values);
    }

    void preorder(TreeNode root,ArrayList<String> list){
        if(root==null){
            list.add("#");
            return;
        }

        list.add(String.valueOf(root.val));
        preorder(root.left,list);
        preorder(root.right,list);
    }

    TreeNode build(String[] values){
        if(index>=values.length){
            return null;
        }

        String value=values[index++];
        if(value.equals("#")){
            return null;
        }
        int val=Integer.parseInt(value);

        TreeNode root=new TreeNode(val);
        root.left=build(values);
        root.right=build(values);
        return root;
    }
}





