/**
 * _4_0_1_knapsack
 */
public class _4_0_1_knapsack {

    public static void main(String[] args) {

        int[] wt = {1, 2, 3, 4};
        int[] value = {4, 5, 6, 7};
        int w = 10;
        int n = wt.length;
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(result(wt, value, w, n, dp));
    }

    static int result(int[] wt, int[] value, int w, int n, int[][] dp) {

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max((value[i - 1] + dp[i - 1][j - wt[i - 1]]), (dp[i - 1][j]));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        return dp[n][w];

    }
}