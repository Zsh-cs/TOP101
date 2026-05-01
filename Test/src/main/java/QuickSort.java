import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums={4,1,5,6,7,3,2};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int p=partition(nums,left,right);
        quickSort(nums,left,p-1);
        quickSort(nums,p+1,right);
    }

    // 划分：每次划分都可以确定一个元素在数组中的位置p
    private static int partition(int[] nums,int left,int right){
        int pivot=nums[left];
        int lt=left;// lt即less than

        // 大放过，小操作
        for(int i=left+1;i<=right;i++){
            if(nums[i]<pivot){
                lt++;
                swap(nums,lt,i);
            }
        }
        swap(nums,left,lt);
        return lt;
    }

    // 交换两个数组元素的位置
    private static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
