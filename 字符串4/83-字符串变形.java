import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param n int整型
     * @return string字符串
     */
    public String trans (String s, int n) {
        StringBuilder res = new StringBuilder();
        // 1.遍历字符串，大小写转换，空格直接拼接
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                res.append(Character.toUpperCase(c));
            } else if (c >= 'A' && c <= 'Z') {
                res.append(Character.toLowerCase(c));
            } else {
                res.append(c);
            }
        }
        // 2.翻转字符串
        res.reverse();
        // 3.再次遍历字符串，以空格为界，翻转每个单词
        int i = 0;
        while (i<n) {
            while (i<n && res.charAt(i) == ' ') {
                i++;
            }
            if(i>=n){
                break;
            }
            int j = i;
            while (j < n && res.charAt(j) != ' '){
                j++;
            }
            StringBuilder sb=new StringBuilder(res.substring(i,j));
            res.replace(i,j,sb.reverse().toString());
            i=j;
        }
        return res.toString();
    }
}


