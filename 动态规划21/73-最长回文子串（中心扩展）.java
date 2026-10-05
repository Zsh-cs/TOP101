import java.util.*;

// 中心扩展
public class Solution {
    
    public int getLongestPalindrome (String A) {
        // 回文串一定是围绕某个中心左右对称的
        // 枚举每一个可能的中心，然后向两边尽可能扩展，直到两端字符不相等或越界
        // 奇数长度回文串的中心是单个字符，偶数中心的回文串是两个字符之间的间隙
        // 所以一共有n+(n-1)=2n-1个中心
        int n=A.length();
        int maxLen=0;
        for(int i=0;i<n;i++){
            maxLen=Math.max(maxLen,expand(A,i,i));
        }
        for(int i=0;i<n-1;i++){
            maxLen=Math.max(maxLen,expand(A,i,i+1));
        }
        return maxLen;
    }

    // 获取回文串长度，统一处理奇偶两种情况
    public int expand(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){ 
            left--;
            right++;
            
        }
        // 循环结束时 left、right 各自多走了一步，有效长度为 (right-left+1)-2=right-left-1
        return right-left-1;
    }
}