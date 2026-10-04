import java.util.*;

// 贪心+二分
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 给定数组的最长严格上升子序列的长度。
     * @param arr int整型一维数组 给定的数组
     * @return int整型
     */
    public int LIS (int[] arr) {
        if(arr==null || arr.length==0){
            return 0;
        }
        // 维护一个数组tails，tails[i]表示长度为i+1的所有上升子序列中，结尾元素的最小值
        // 结尾越小，后面越容易接新元素，所以我们只保留最小的
        // 可以证明tails是严格递增的，因此可以二分查找
        // 从前往后遍历arr，x 比tails里所有数都大就追加；否则替换tails中第一个 >= x 的位置
        ArrayList<Integer> tails=new ArrayList<>();
        tails.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]>tails.get(tails.size()-1)){
                tails.add(arr[i]);
            }else{
                update(tails,arr[i]);
            }
        }
        return tails.size();
    }

    public void update(ArrayList<Integer> tails, int x){
        int left=0;
        int right=tails.size()-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(tails.get(mid)<x){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        // 跳出循环后，left==right
        tails.set(left,x);
    } 
}


