import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param num int整型一维数组 
     * @param size int整型 
     * @return int整型ArrayList
     */
    public ArrayList<Integer> maxInWindows (int[] num, int size) {
        ArrayList<Integer> list=new ArrayList<>();
        Deque<Integer> q=new ArrayDeque<>();// 双端队列，存储数组下标

        // 窗口大于数组长度或窗口长度为0的时候，返回空
        if(size==0 || size>num.length){
            return list;
        }

        // 维护一个下标对应元素是单调递减的双端队列
        for(int i=0;i<num.length;i++){
            // 1.去尾：保证队列单调性
            while(!q.isEmpty() && num[i]>=num[q.peekLast()]){
                q.pollLast();
            }

            // 2.入队：让新人等待上位机会
            q.addLast(i);

            // 3.掐头：淘汰已经离开窗口范围的老人
            if(q.peekFirst()<=i-size){
                q.pollFirst();
            }

            // 4.开始形成窗口后，将队头下标对应元素放入list
            if(i>=size-1){
                list.add(num[q.peekFirst()]);
            }
        }
        
        return list;
    }
}




