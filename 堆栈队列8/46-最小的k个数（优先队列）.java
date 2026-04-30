import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param input int整型一维数组 
     * @param k int整型 
     * @return int整型ArrayList
     */
    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        if(input.length==0 || k==0){
            return list;
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);// 降序优先队列
        for(int i=0;i<k;i++){
            pq.add(input[i]);
        }
        for(int i=k;i<input.length;i++){
            if(input[i]<pq.peek()){
                pq.poll();
                pq.add(input[i]);
            }
        }

        for(int i=0;i<k;i++){
            list.add(pq.poll());
        }
        return list;
    }
}