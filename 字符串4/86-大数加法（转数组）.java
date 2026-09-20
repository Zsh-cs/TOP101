import java.util.*;


public class Solution {

    public String solve (String s, String t) {
        if(s.length()==0){
            return t;
        }
        if(t.length()==0){
            return s;
        }
        int len=Math.max(s.length(),t.length());
        int[] num1=changeToNum(s,len);
        int[] num2=changeToNum(t,len);
        int[] res=new int[len+1];
        int carry=0;
        for(int i=0;i<len;i++){
            int sum=num1[i]+num2[i]+carry;
            res[i]=sum%10;
            carry=sum/10;
        }
        res[len]=carry;
        StringBuilder sb=new StringBuilder();
        int k=len;
        while(res[k]==0 && k>0){
            k--;
        }
        for(int i=k;i>=0;i--){
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public int[] changeToNum(String s,int len){
        int[] num=new int[len];
        int j=0;
        for(int i=s.length()-1;i>=0;i--){
            num[j++]=s.charAt(i)-'0';
        }
        return num;
    }
}