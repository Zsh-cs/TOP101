import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 比较版本号
     * @param version1 string字符串 
     * @param version2 string字符串 
     * @return int整型
     */
    public int compare (String version1, String version2) {
        String[] nums1=version1.split("\\.");// 两个反斜杠都是转义字符
        String[] nums2=version2.split("\\.");

        for(int i=0;i<nums1.length || i<nums2.length;i++){
            // 较短的版本后续都取0
            String s1 = i<nums1.length ? nums1[i] : "0";
            String s2 = i<nums2.length ? nums2[i] : "0";
            int num1=Integer.parseInt(s1);
            int num2=Integer.parseInt(s2);
            if(num1>num2){
                return 1;
            }
            if(num1<num2){
                return -1;
            }
        }
        return 0;
    }
}