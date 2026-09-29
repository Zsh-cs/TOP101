import java.util.*;
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i=0,j=0,k=0;
        int[] C=new int[m+n];
        while(i<m || j<n){
            if(i==m){
                C[k++]=B[j++];
            }else if(j==n){
                C[k++]=A[i++];
            }else if(A[i]<B[j]){
                C[k++]=A[i++];
            }else{
                C[k++]=B[j++];
            }
        }
        for(int l=0;l<m+n;l++){
            A[l]=C[l];
        }
    }
}