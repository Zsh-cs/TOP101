import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param cost int整型一维数组 
     * @return int整型
     */
    public int minCostClimbingStairs (int[] cost) {
        // dp[i]表示爬到第i阶楼梯需要的最小花费
        int[] dp=new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;

        for(int i=2;i<dp.length;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}