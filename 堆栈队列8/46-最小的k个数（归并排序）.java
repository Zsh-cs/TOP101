import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param input int整型一维数组 
     * @param k int整型 
     * @return int整型ArrayList
     */
    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        mergeSort(input,0,input.length-1);
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

    // 归并排序
    private void mergeSort(int[] input,int left,int right){
        if(left>=right){
            return;
        }

        int mid=left+(right-left)/2;
        mergeSort(input,left,mid);
        mergeSort(input,mid+1,right);
        merge(input,left,mid,right);
    }

    private void merge(int[] input,int left,int mid,int right){
        int len=right-left+1;
        int[] temp=new int[len];
        for(int i=0;i<len;i++){
            temp[i]=input[left+i];
        }

        int i=0;
        int j=mid-left+1;
        for(int k=0;k<len;k++){
            if(i==mid-left+1){
                input[left+k]=temp[j];
                j++;
            }else if(j==len){
                input[left+k]=temp[i];
                i++;
            }else if(temp[i]<=temp[j]){
                input[left+k]=temp[i];
                i++;
            }else{
                input[left+k]=temp[j];
                j++;
            }
        }
    }
}



