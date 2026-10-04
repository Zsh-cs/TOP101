import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 最少货币数
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public int minMoney (int[] arr, int aim) {
        // dp[i]表示组成i的最少货币数
        int[] dp = new int[aim + 1];
        dp[0] = 0;
        // 其余dp[i]初始化为aim+1，表示暂时凑不出
        for (int i = 1; i <= aim; i++) {
            dp[i] = aim + 1;
        }
        for (int i = 1; i <= aim; i++) {
            for (int value : arr) {
                if (value <= i) {
                    dp[i] = Math.min(dp[i], dp[i - value] + 1);
                }
            }
        }
        return dp[aim]<=aim ? dp[aim] : -1;
    }
}