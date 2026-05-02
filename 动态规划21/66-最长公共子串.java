import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        int m=str1.length();
        int n=str2.length();
        // dp[i][j]表示以str1的第i个字符和str2的第j个字符结尾的最长公共子串的长度
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=0;

        int maxLen=0;
        int lastIndex=0; // 记录最长子串在str1中结束的位置

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(dp[i][j]>maxLen){
                        maxLen=dp[i][j];
                        lastIndex=i;
                    }
                }else{
                    dp[i][j]=0;
                }
            }
        }

        return str1.substring(lastIndex-maxLen,lastIndex);
    }
}