public class _3_matrixchainmultiplication {
    static int MatrixChainOrder(int p[], int i, int j) {
        if (i == j)
            return 0;
        
        int mini = Integer.MAX_VALUE;
        int count;
 
        for (int k = i; k < j; k++) {
            count = MatrixChainOrder(p, i, k)
                    + MatrixChainOrder(p, k + 1, j)
                    + p[i - 1] * p[k] * p[j];
 
            if (count < mini) {
                mini = count;
            }
        }
 
        return mini;
    }
    
    public static void main(String[] args) {
        int arr[] = { 10,100,5,500 };
        int N = arr.length;
 
        System.out.println("Minimum number of multiplications is " +
                MatrixChainOrder(arr, 1, N - 1));
    }
}
