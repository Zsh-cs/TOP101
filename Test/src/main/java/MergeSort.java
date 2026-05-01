import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums={8,6,7,5,4,3,2,1};
        int len=nums.length;
        // 全局使用同一个临时数组，避免频繁创建和销毁数组导致的开销
        int[] temp=new int[len];
        mergeSort(nums,0,len-1,temp);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 对数组nums在区间[left,right]内进行归并排序
     *
     * @param nums 待排序的数组
     * @param left 左边界，可以取到
     * @param right 右边界，可以取到
     */
    private static void mergeSort(int[] nums, int left, int right, int[] temp) {
        // 首先要写递归终止条件，否则会导致函数陷入死循环
        if(left>=right){
            return;
        }

        int mid=left+(right-left)/2;// mid是前半部分最后一个元素的下标
        mergeSort(nums,left,mid,temp);
        mergeSort(nums,mid+1,right,temp);

        // 数组已经有序的情况下，不再合并
        if(nums[mid]<=nums[mid+1]){
            return;
        }
        mergeTwoSortedArray(nums,left,mid,right,temp);
    }

    private static void mergeTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i]=nums[i];
        }

        // temp数组前半部分和后半部分分别有序
        // i是用来遍历temp数组前半部分的指针，j是用来遍历temp数组后半部分的指针
        int i=left;
        int j=mid+1;
        for(int k=left;k<=right;k++){
            if(i==mid+1){
                nums[k]=temp[j];
                j++;
            }else if(j==right+1){
                nums[k]=temp[i];
                i++;
            }else if(temp[i]<=temp[j]){
                nums[k]=temp[i];
                i++;
            }else{
                nums[k]=temp[j];
                j++;
            }
        }
    }

}
