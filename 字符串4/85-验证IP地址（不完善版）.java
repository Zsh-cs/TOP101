import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 验证IP地址
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    public String solve (String IP) {
        if(IP.contains(".")){
            return checkIPv4(IP);
        }else if(IP.contains(":")){
            return checkIPv6(IP);
        }else{
            return "Neither";
        }
    }

    public String checkIPv4(String IP){
        String[] numStrs=IP.split("\\.",-1);// 要转义
        if(numStrs.length!=4){
            return "Neither";
        }
        for(String numStr: numStrs){
            if(numStr.length()>1 && numStr.startsWith("0")){
                return "Neither";
            }
            for(int i=0;i<numStr.length();i++){
                char c=numStr.charAt(i);
                if(!Character.isDigit(c)){
                    return "Neither";
                }
            }
            int num=Integer.valueOf(numStr);
            if(num<0 || num>255){
                return "Neither";
            }  
        }
        return "IPv4";
    }

    public String checkIPv6(String IP){
        if(IP.contains("::")){
            return "Neither";
        }
        String[] numStrs=IP.split(":",-1);
        if(numStrs.length!=8){
            return "Neither";
        }
        for(String numStr: numStrs){
            if(numStr.length()>4){
                return "Neither";
            }
            for(int i=0;i<numStr.length();i++){
                char c=numStr.charAt(i);
                if(Character.isLetter(c)){
                    c=Character.toLowerCase(c);
                    if(c>'f'){
                        return "Neither";
                    }
                }
            }
        }
        return "IPv6";
    }
}


