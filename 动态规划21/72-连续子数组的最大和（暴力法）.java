import java.util.*;

// 暴力法
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param array int整型一维数组 
     * @return int整型
     */
    public int FindGreatestSumOfSubArray (int[] array) {
        int max=array[0];
        for(int i=0;i<array.length;i++){
            int sum=0;
            for(int j=i;j<array.length;j++){
                sum+=array[j];
                if(sum>max){
                    max=sum;
                }
            }
        }
        return max;
    }
}