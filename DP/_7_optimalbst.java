
public class _7_optimalbst {
    public static int optimalBST(int[] keys, int[] freq) {
        int n = keys.length;
        int[][] dp = new int[n][n];
    
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                int sum = sum(freq, i, j);
                for (int k = i; k <= j; k++) {
                    int cost = sum + (k - 1 < i ? 0 : dp[i][k - 1]) + (k + 1 > j ? 0 : dp[k
                            + 1][j]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[0][n - 1];
    }
    private static int sum(int[] freq, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += freq[k];
        }   
        return sum;
    }
    public static void main(String[] args) {
        int[] keys = {10, 20, 30, 40, 50, 60, 70};
        int[] freq = {0,1,3,4,5,1,0};
        System.out.println("Minimum cost to construct optimal BST: " + optimalBST(keys,
                freq));
    }
    
}

 
