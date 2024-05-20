import java.util.ArrayList;
import java.util.List;

public class _5_subsetsum {
    public static void main(String[] args) {
          int[] array={1,2,3};
          int sum=4;
          boolean dp[][]=new boolean[array.length+1][sum+1];

          for(int i=0;i< array.length+1;i++){
              for(int j=0;j<sum+1;j++){
                  if(i==0){
                      dp[i][j]=false;
                  }
                  if(j==0){
                      dp[i][j]=true;
                  }
              }
          }

        printSubsetWithSum(dp,sum, array.length, array);
    }
    static  boolean result(boolean dp[][],int sum,int n,int[]array){
       for(int i=1;i<n+1;i++){
           for(int j=1;j<sum+1;j++){
               if(array[i-1]<=j){
                   dp[i][j]=(dp[i-1][j-array[i-1]])||(dp[i-1][j]);
               }
               else{
                   dp[i][j]=dp[i-1][j];
               }
           }
       }
       return dp[n][sum];
    }
static void printSubsetWithSum(boolean[][] dp, int sum, int n, int[] array) {
    if (!result(dp, sum, n, array)) {
        System.out.println("No subset found with the given sum.");
        return;
    }

    List<Integer> subset = new ArrayList<>();
    findSubset(dp, sum, n, array, subset);

    System.out.println("Subset with sum " + sum + ": " + subset);
}

    static boolean findSubset(boolean[][] dp, int sum, int n, int[] array, List<Integer> subset) {
        if (sum == 0) {
            return true;
        }
        if (n == 0 || sum < 0) {
            return false;
        }

        // If the current element is included in the subset
        if (dp[n][sum] && array[n - 1] <= sum) {
            if (findSubset(dp, sum - array[n - 1], n - 1, array, subset)) {
                subset.add(array[n - 1]);
                return true;
            }
        }
        if (dp[n - 1][sum]) {
            if (findSubset(dp, sum, n - 1, array, subset)) {
                return true;
            }
        }

        return false;
    }
}
