import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型
     */
    public int minNumberInRotateArray (int[] nums) {
        int left=0;
        int right=nums.length-1;

        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[right]){
                left=mid+1;
            }else if(nums[mid]<nums[right]){
                right=mid;
            }else{
                right--;
            }
        }

        // left和right重合时，left（或right）指向的就是最小值
        return nums[left];
    }
}