
public class _1_longestcommonsubsequence {
    public static void main(String[] args) {
        String a = "ABCBDAB";
        String b = "BDCABA";
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];


        for(int i =0; i<m+1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = 0;
            }
        }

        System.out.println(lcs(a, b, m, n, dp));
    }

    static int lcs(String a, String b, int m, int n, int[][] dp) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j<= n; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
    
}