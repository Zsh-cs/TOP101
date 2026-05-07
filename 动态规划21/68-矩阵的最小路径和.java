import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {

        int m=matrix.length;
        int n=matrix[0].length;

        // dp[i][j]表示到达(i,j)的最小路径和
        int[][] dp=new int[m+1][n+1];
        dp[1][1]=matrix[0][0];
        for(int i=2;i<=m;i++){
            dp[i][1]=dp[i-1][1]+matrix[0][i-1];
        }
        for(int j=2;j<=n;j++){
            dp[1][j]=dp[1][j-1]+matrix[j-1][0];
        }

        for(int i=2;i<=m;i++){
            for(int j=2;j<=n;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+matrix[j-1][i-1];
            }
        }
        return dp[m][n];
    }
}