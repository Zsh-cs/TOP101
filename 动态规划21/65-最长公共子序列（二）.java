import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String s1, String s2) {
        // dp[i][j]表示s1的前i个字符和s2的前j个字符的LCS长度
        int m=s1.length();
        int n=s2.length();
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=0;

        int i,j;
        for(i=1;i<=m;i++){
            for(j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        if(dp[m][n]==0){
            return "-1";
        }

        StringBuilder res=new StringBuilder();
        i=m;j=n;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                res.append(s1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>=dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        return res.reverse().toString();
    }
}