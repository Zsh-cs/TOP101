import java.util.*;

// 动态规划
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 给定数组的最长严格上升子序列的长度。
     * @param arr int整型一维数组 给定的数组
     * @return int整型
     */
    public int LIS (int[] arr) {
        if(arr==null || arr.length==0){
            return 0;
        }
        int n=arr.length;
        // dp[i]表示以arr[i]结尾的最长严格上升子序列的长度
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int maxLen=1;
        for(int i=1;i<n;i++){
            if(dp[i]>maxLen){
                maxLen=dp[i];
            }
        }
        return maxLen;
    }
}