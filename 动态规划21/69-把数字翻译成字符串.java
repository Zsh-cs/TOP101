import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 解码
     * @param nums string字符串 数字串
     * @return int整型
     */
    public int solve (String nums) {

        // 如果数字串以0开头，则无法译码
        if(nums.charAt(0)=='0'){
            return 0;
        }

        // dp[i]表示长度为i的数字串有多少种可能的译码结果
        int[] dp=new int[nums.length()+1];
        dp[0]=1;// 空数字串也有一种译码方式
        dp[1]=1;// 已经排除了以0开头的数字串，所以绝对有一种译码方式

        for(int i=2;i<=nums.length();i++){
            // 单字成码
            if(nums.charAt(i-1)!='0'){
                dp[i]+=dp[i-1];
            }
            
            // 双字成码
            int num=Integer.parseInt(nums.substring(i-2,i));
            if(num>=10 && num<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[nums.length()];
    }
}