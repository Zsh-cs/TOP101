import java.util.*;


public class Solution {
    
    // 排序+双指针
    public ArrayList<ArrayList<Integer>> threeSum (int[] num) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();

        // 1.排序
        Arrays.sort(num);
        // 2.寻找三元组
        int n=num.length;
        if(n<3){
            return res;
        }
        for(int i=0;i<n-2;i++){
            // 剪枝：某一个数大于0，后面都是更大的，不可能三数之和为0了
            if(num[i]>0){
                break;
            }
            // 去重：某一个数与前一个数相等，直接跳过本轮循环
            if(i>0 && num[i]==num[i-1]){
                continue;
            }
            // 双指针
            int target=-num[i];
            int left=i+1,right=n-1;
            while(left<right){
                if(num[left]+num[right]>target){
                    right--;
                }else if(num[left]+num[right]<target){
                    left++;
                }else{
                    ArrayList<Integer> list=new ArrayList<>(
                        Arrays.asList(num[i],num[left],num[right]));
                    res.add(list);
                    left++;
                    right--;   
                    // 去重：跳过相同的left和right
                    while(left<right && num[left]==num[left-1]){
                        left++;
                    }
                    while(left<right && num[right]==num[right+1]){
                        right--;
                    } 
                }
            }
        }

        return res;
    }
}



