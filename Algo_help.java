/*
 
 Written by Tharaka Sachintha Ratnayake
 Currently included:
 
 1. Binary Search using iteration
 2. Bianry Search using recursion
 3. Merge algorithm
 4. Merge Sort
 
*/


import java.lang.Math;

public class Algo_help {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] A = new int[]{1, 22, 56, 76, 123};
        int[] B = new int[]{5,6,7,2,23,445,2345,45,34,656,2,34,6,5,6,43,63,34,56,234,2,33};
        //int c = BinarySearch_iterative(A, 8, 46);
        
        int[] c = MergeSort(B,0,B.length-1);
        int d = BinarySearch_recursive(A, 0, 7, 46);
        
        //System.out.println(d);
        for(int i =0; i<c.length;i++){
            System.out.println(c[i]);
        }
        
    }

    static int BinarySearch_iterative(int[] A, int n, int Key) {

        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = Math.floorDiv(start + end, 2);
            if (Key == A[mid]) {
                return mid;
            }
            if (Key > A[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
 
        return -1;
    }

    static int BinarySearch_recursive(int[] A, int start, int end, int Key) {
            int mid = Math.floorDiv(start + end, 2);
            
            if(start > end){
              return -1;   
            }
            if (Key == A[mid]){
              return mid;
            }
            if(Key > A[mid]){
              return BinarySearch_recursive(A, mid+ 1, end, Key); 
            }
            else{
               return BinarySearch_recursive(A, start, mid-1 , Key);  
            }
}
static int[] MergeSort(int[] list, int start, int end) {
    if(start == end){
        int[] ret = new int[1];
        ret[0] = list[start];
        return ret;
    }
    int mid = Math.floorDiv(start + end, 2);
    int[] A = MergeSort(list, start, mid);
    int[] B = MergeSort(list, mid + 1, end);
    
    int[] c = Merge(A,B);
    return c;
   
}

static int[] Merge(int[] A,int[] B){
    int pointer_A = 0;
    int pointer_B = 0;
    int j = 0;
    int[] result = new int[A.length+ B.length];
    while(pointer_A < A.length && pointer_B < B.length ){
         if(A[pointer_A] >= B[pointer_B]){
            result[j] = B[pointer_B];
            j++;
            pointer_B++;       
         }
    else{
            result[j] = A[pointer_A];
            j++;
            pointer_A++;           
         }
    }
    if(pointer_A < A.length ){
    for(int i = pointer_A ; i <= A.length -1 ;i++){
       result[j] = A[i];
       j++;
    }
    }
    if(pointer_B < B.length ){
    for(int i = pointer_B ; i <= B.length -1 ;i++){
       result[j] = B[i];
       j++;
    }
    }
    return result;
}
}
