import java.util.*;
import java.util.Stack;

public class Solution {

    private Stack<Integer> stack=new Stack<>();
    
    public void push(int node) {
        stack.push(node);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        ArrayList<Integer> assist=new ArrayList<>();// 每次都使用一个全新的辅助数组
        
        while(!stack.isEmpty()){
            assist.add(stack.pop());
        }
        int minVal=assist.get(0);
        for(int val:assist){
            if(val<minVal){
                minVal=val;
            }
        }

        // 恢复原来的栈
        for(int i=assist.size()-1;i>=0;i--){
            stack.push(assist.get(i));
        }

        return minVal;
    }
}



