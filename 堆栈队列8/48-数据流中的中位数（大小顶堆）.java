import java.util.*;

// 大小顶堆法
public class Solution {

    // 大顶堆：放所有数字中较小的那一部分，即排序后数组的左半部分，这样堆顶元素是离数组中间最近的左边那个数字
    private PriorityQueue<Integer> left=new PriorityQueue<>((a,b)->b-a);
    // 小顶堆：放所有数字中较大的那一部分，即排序后数组的右半部分，这样堆顶元素是离数组中间最近的右边那个数字
    private PriorityQueue<Integer> right=new PriorityQueue<>();

    public void Insert(Integer num) {
        left.offer(num);
        right.offer(left.poll());
        if(right.size()>left.size()){
            left.offer(right.poll());
        }
    }

    public Double GetMedian() {
        int size=left.size()+right.size();
        if(size%2==1){
            return (double)left.peek();
        }else{
            double a=left.peek();
            double b=right.peek();
            return (a+b)/2;
        }
    }


}
