import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param strs string字符串一维数组 
     * @return string字符串
     */
    public String longestCommonPrefix (String[] strs) {
        int n=strs.length;
        if(n==0 || strs[0].length()==0){
            return "";
        }

        for(int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            for(int j=1;j<n;j++){
                if(i>=strs[j].length() || strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}