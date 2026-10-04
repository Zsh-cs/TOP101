import java.util.*;

// 动态规划
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param array int整型一维数组 
     * @return int整型
     */
    public int FindGreatestSumOfSubArray (int[] array) {
        int n=array.length;
        // dp[i]表示以array[i]结尾的连续子数组的最大和
        int[] dp=new int[n];
        dp[0]=array[0];

        int max=array[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+array[i],array[i]);
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
}