import java.util.*;
import java.util.Stack;

public class Solution {

    // 双栈
    private Stack<Integer> stack=new Stack<>();
    private Stack<Integer> minStack=new Stack<>();
    
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty() || node<minStack.peek()){
            minStack.push(node);
        }else{
            minStack.push(minStack.peek());// 否则重复入栈
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}
