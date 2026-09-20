import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        StringBuilder sb=new StringBuilder();
        int i=s.length()-1,j=t.length()-1,carry=0;
        while(i>=0 || j>=0 || carry>0){
            int sum=carry;
            if(i>=0){
                sum+=s.charAt(i--)-'0';
            }
            if(j>=0){
                sum+=t.charAt(j--)-'0';
            }
            sb.append(sum%10);
            carry=sum/10;
        }
        return sb.reverse().toString();
    }
}