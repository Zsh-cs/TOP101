import java.util.*;


public class Solution {

    // 原地哈希：数组索引为i的位置存储i+1，从头遍历，找出没有存储对应整数的索引，+1即为结果
    public int minNumberDisappeared (int[] nums) {
        // 数组的长度为n，没有出现的最小正整数一定在[1,n+1]这个区间，原因如下：
        // 假如数组恰好是[1,2,3,...,n]，则该数是n+1
        // 其他情况下，数组必然缺失了1~n中的某些数字，则该数就是这些缺失数字中最小那一个
        int n=nums.length;
        for(int i=0;i<n;i++){
            // 只要当前数字在[1, n]范围内，且它没有待在正确位置上，就一直交换
            // 1<=x<=n && nums[x-1]!=x
            // 防御性编程，防止数组有重复数字陷入死循环
            while(nums[i]>=1 && nums[i]<=n && nums[nums[i]-1]!=nums[i]){
                swap(nums,i,nums[i]-1);
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}