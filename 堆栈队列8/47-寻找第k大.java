import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param a int整型一维数组 
     * @param n int整型 
     * @param K int整型 
     * @return int整型
     */
    public int findKth (int[] a, int n, int K) {
        return quickSelect(a,0,n-1,K);
    }

    // 类似于二分查找
    private int quickSelect(int[] a,int left,int right,int k){
        int p=partition(a,left,right);
        if(p==k-1){
            return a[p];
        }else if(p>k-1){
            return quickSelect(a,left,p-1,k);
        }else{
            return quickSelect(a,p+1,right,k);
        }
    }

    private int partition(int[] a,int left,int right){
        int pivot=a[left];
        int gt=left;

        // 小放过，大操作
        for(int i=left+1;i<=right;i++){
            if(a[i]>pivot){
                gt++;
                swap(a,gt,i);
            }
        }
        swap(a,left,gt);
        return gt;
    }

    private void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}