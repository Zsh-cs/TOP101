import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param target int整型 
     * @param array int整型二维数组 
     * @return bool布尔型
     */
    public boolean Find (int target, int[][] array) {
        // 健壮性检查：如果数组本身是空的，或者第一行就是空的，直接返回 false
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        // m行n列的矩阵
        // 以右上角为起点的消去法
        int row=0;
        int rowCount=array.length-1;
        int col=array[row].length-1;
        while(row<=rowCount && col>=0){
            if(array[row][col]==target){
                return true;
            }else if(array[row][col]<target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}