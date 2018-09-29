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
 
 
 
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//  
//                  Greedy Method
//   
//            Used For optimization problems 
//            Which mean for finding minimum or maximum
//
//           Methods used for optimizaiton probelms
//
//            1.Greedy Method
//            2.Dynamic Programming
//            3.Branch and Bround
//
//     
//      a = [ feature space ]
//      Algorithm Greedy(a,n){
//       
//       for i = 1 to n do{
//          x = select(a)
//         if feasible(x) then
//                  solution = solution +x
//        }
//       }
//
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++




// This method can be used when you can choose a fractional vlaur
// to fill up the knapsack. 
// When you can't pick fractional values you have to solve it using 
// Dynamic programming.
static float KnapsackProblem_Greedy(int[][] list , int weight){

float [][] ratio = new float[list.length][3];
for(int i = 0; i < list.length; i++){
    ratio[i][0] = list[i][0];  //profit
    ratio[i][1] = list[i][1];  //weight
    ratio[i][2] = (float)list[i][0] / list[i][1];
}
Arrays.sort(ratio, new Comparator<float[]>() {
    public int compare(float[] s1, float[] s2) {
        if (s1[2] < s2[2])
            return 1;    // tells Arrays.sort() that s1 comes after s2
        else if (s1[2]> s2[2])
            return -1;   // tells Arrays.sort() that s1 comes before s2
        else {
            /*
             * s1 and s2 are equal.  Arrays.sort() is stable,
             * so these two rows will appear in their original order.
             * You could take it a step further in this block by comparing
             * s1[1] and s2[1] in the same manner, but it depends on how
             * you want to sort in that situation.
             */
            return 0;
        }
    }
});

//for(int i = 0 ; i< ratio.length;i++){
//   System.out.print(ratio[i][0]);
//   System.out.print(" - ");
//   System.out.print(ratio[i][1]);
//   System.out.print(" - ");
//   System.out.print(ratio[i][2]);
//   System.out.println();
//}
float current_weight = 0;
float profit = 0 ;
for(int i = 0 ; i< list.length; i++){
    
    // If adding Item won't overflow, add it completely 
    if(current_weight + ratio[i][1]<= weight){
       current_weight += ratio[i][1];
       profit += ratio[i][0];
    }
    
    // If we can't add current Item, add fractional part of it 
    else{
        float remain = weight - current_weight;
        profit +=  ratio[i][2]*remain;
        break;
    }
}
   return profit;
}

}
