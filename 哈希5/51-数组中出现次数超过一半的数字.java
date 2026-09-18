import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param numbers int整型一维数组 
     * @return int整型
     */
    public int MoreThanHalfNum_Solution (int[] numbers) {
        int len=numbers.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(numbers[i],map.getOrDefault(numbers[i],0)+1);
            if(map.get(numbers[i])>len/2){
                return numbers[i];
            }
        }
        return -1;
    }
}