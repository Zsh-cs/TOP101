import java.util.*;


public class Solution {
    
    // 位运算
    public int[] FindNumsAppearOnce (int[] nums) {
        // 异或的性质：a^a=0, a^0=a
        // 把所有数异或一遍
        // 数组里所有出现两次的数，异或后都会两两抵消变成0
        // 剩下的就是那两个只出现一次的数的异或结果a^b
        int xorAll=0;
        for(int num: nums){
            xorAll^=num;
        }

        // 因为a!=b，所以a^b结果里至少有一位是1
        // 我们根据最低位的1进行与运算分组
        int mask=1;
        while((xorAll&mask)==0){
            mask=mask<<1;
        }
        int a=0,b=0;
        for(int num: nums){
            if((num&mask)==0){
                a^=num;
            }
        }
        b=xorAll^a;
        return a<b ? new int[]{a,b} : new int[]{b,a};
    }
}