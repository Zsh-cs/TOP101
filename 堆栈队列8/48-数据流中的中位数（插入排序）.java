import java.util.*;

// 插入排序法
public class Solution {

    private ArrayList<Integer> list=new ArrayList<>();

    public void Insert(Integer num) {
        if(list.isEmpty()){
            list.add(num);
        }else{
            int i;
            for(i=0;i<list.size();i++){
                if(num<=list.get(i)){
                    break;
                }
            }
            list.add(i,num);
        }
    }

    public Double GetMedian() {
        int n=list.size();
        if(n%2==1){
            return (double)list.get(n/2);
        }else{
            double a=list.get(n/2-1);
            double b=list.get(n/2);
            return (a+b)/2;
        }
    }


}
