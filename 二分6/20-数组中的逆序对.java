import java.util.*;


public class Solution {

    public static final int MOD=1000000007;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型
     */
    public int InversePairs (int[] nums) {
        // 7%1000000007=7
        if(nums==null || nums.length<=1){
            return 0;
        }
        return mergeSort(nums,0,nums.length-1);
    }

    public int mergeSort(int[] nums,int left,int right){
        if(left>=right){
            return 0;
        }
        int mid=left+(right-left)/2;
        int leftCount=mergeSort(nums,left,mid);
        int rightCount=mergeSort(nums,mid+1,right);
        int mergeCount=mergeTwoSortedArray(nums,left,mid,right);
        return (leftCount+rightCount+mergeCount)%MOD;// 及时取模，防止溢出
    }

    public int mergeTwoSortedArray(int[] nums,int left,int mid,int right){
        int count=0;
        int len=right-left+1;
        int[] temp=new int[len];
        for(int i=0;i<len;i++){
            temp[i]=nums[left+i];
        }

        int i=0;
        int j=mid-left+1;
        for(int k=0;k<len;k++){
            if(i==mid-left+1){
                nums[left+k]=temp[j];
                j++;
            } else if(j==len){
                nums[left+k]=temp[i];
                i++;
            } else if(temp[i]<=temp[j]){
                nums[left+k]=temp[i];
                i++;
            } else{
                nums[left+k]=temp[j];
                count+=mid-left-i+1;
                j++;
            }
        }
        return count%MOD;// 及时取模，防止溢出
    }
}






