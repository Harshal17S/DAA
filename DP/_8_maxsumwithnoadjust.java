public class _8_maxsumwithnoadjust {
    static int findMaxSum(int[] arr, int N)
    {
        int[][] dp = new int[N][2];
        if (N == 1) {
            return arr[0];
        }

        dp[0][0] = 0;
        dp[0][1] = arr[0];

        for (int i = 1; i < N; i++) {
            dp[i][1] = dp[i - 1][0] + arr[i];
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
        }

       
        return Math.max(dp[N - 1][0], dp[N - 1][1]);
    }


    
    public static void main(String args[])
    {

       
        int[] arr = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
        int N = arr.length;

     
        System.out.println(findMaxSum(arr, N));
    }
}
