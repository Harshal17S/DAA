public class _9_maximunsumsubarray {
    public static void main(String[] args) {
        System.out.println(sumArr(new int[]{2, -4, 1, 9, -6, 7, -3},0,6));
    }

    public static int sumArr(int []arr,int lo, int hi){
        if(lo==hi){
            return arr[lo];
        }

        int mid = lo+(hi-lo)/2;
        int leftSum = sumArr(arr,lo,mid);
        int rightSum = sumArr(arr,mid+1,hi);

        int mixSum = mixSum_arr(arr,lo,hi);

        return Math.max(mixSum, Math.max(leftSum,rightSum));
    }

    public static int mixSum_arr(int []arr, int lo,int hi){
        int leftMax=Integer.MIN_VALUE;
        int leftSum = 0;
        int mid = lo +(hi-lo)/2;
        for(int i=mid; i>=lo;--i){
            leftSum +=arr[i];
            leftMax = Math.max(leftMax,leftSum);
        }

        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for(int j=mid+1;j<=hi;j++){
         rightSum+=arr[j];
            rightMax=Math.max(rightSum,rightMax);
        }
        return leftMax+rightMax;
    }
}
