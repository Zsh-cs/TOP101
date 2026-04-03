import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums={8,6,7,5,4,3,2,1};
        mergeSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 对数组nums在区间[left,right]内进行归并排序
     *
     * @param nums 待排序的数组
     * @param left 左边界，可以取到
     * @param right 右边界，可以取到
     */
    private static void mergeSort(int[] nums, int left, int right) {
        // 首先要写递归终止条件，否则会导致函数陷入死循环
        if(left>=right){
            return;
        }

        int mid=left+(right-left)/2;// mid是前半部分最后一个元素的下标
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        mergeTwoSortedArray(nums,left,mid,right);
    }

    private static void mergeTwoSortedArray(int[] nums, int left, int mid, int right) {
        int len=right-left+1;
        int[] temp=new int[len];
        for (int i = 0; i < len; i++) {
            temp[i]=nums[left+i];
        }

        // temp数组前半部分和后半部分分别有序
        // i是用来遍历temp数组前半部分的指针，j是用来遍历temp数组后半部分的指针
        int i=0;
        int j=mid-left+1;
        for (int k = 0; k < len; k++) {
            // 先写i和j越界的情况
            if(i==mid-left+1){
                nums[left+k]=temp[j];
                j++;
            } else if (j == len) {
                nums[left+k]=temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[left+k]=temp[i];
                i++;
            } else {
                nums[left+k]=temp[j];
                j++;
            }
        }
    }

}
