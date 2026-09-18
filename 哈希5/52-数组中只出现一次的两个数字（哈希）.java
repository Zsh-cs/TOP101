import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce (int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int[] res=new int[2];
        int index=0;
        for(int num: map.keySet()){
            if(map.get(num)==1){
                res[index++]=num;
            }
        }
        if(res[0]>res[1]){
            int temp=res[0];
            res[0]=res[1];
            res[1]=temp;
        }
        return res;
    }
}