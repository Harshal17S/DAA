import java.util.Arrays;

/**
 * _5_pairdifferncek
 */
public class _5_pairdifferncek {

     public static void main(String[] args) {
        mergeSort(new int[]{1, 5, 2, 2, 2, 5, 5, 4},3);
    }

    public static int[]  pair_diff(int []left, int []right,int target){
        int i=0;
        int j=0;

        while(i<left.length && j<right.length){
            if(Math.abs(left[i]-right[i]) == target){
                System.out.println(left[i] +" "+ right[j]);
            }
            i++;j++;
        }
        return new int[]{-1,-1};
    }

    public static int[] mergeSort(int []arr, int target){
        if(arr.length == 1){
            return arr;
        }

        else{
            int mid = arr.length /2;
            int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid),3);
            int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length),3);

            return pair_diff(left, right,3);
        }
    }
}