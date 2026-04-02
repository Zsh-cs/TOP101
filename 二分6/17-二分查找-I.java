import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @param target int整型 
     * @return int整型
     */
    public int search (int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid;

        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            } else if(nums[mid]<target){
                // target在右半部分
                left=mid+1;
            } else{
                // target在左半部分
                right=mid-1;
            } 
        }
        return -1;
    }

}