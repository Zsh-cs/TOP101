import java.util.*;

// 动态规划
public class Solution {

    public int getLongestPalindrome (String A) {
        int n = A.length();
        // dp[i][j]表示A[i...j]是否为回文子串
        boolean[][] dp = new boolean[n][n];

        // 安全的遍历顺序：i从大到小，j从i到n-1
        // 外层i倒着走，保证i+1行已完成
        int maxLen=0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j == i) {
                    dp[i][j] = true;
                } else if (j - i == 1 || j - i == 2) {
                    dp[i][j] = (A.charAt(i) == A.charAt(j));
                } else {
                    dp[i][j] = (A.charAt(i) == A.charAt(j)) && dp[i + 1][j - 1];
                }
                if(dp[i][j]){
                    maxLen=Math.max(maxLen,j-i+1);
                }
            }
        }
        return maxLen;
    }
}