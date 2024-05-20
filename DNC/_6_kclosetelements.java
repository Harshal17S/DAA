import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _6_kclosetelements {
     public static void main(String[] args) {
        System.out.println(closest_numbers(new int[]{10,12,15,17,18,20,25},4,16));
    }

    public static List<Integer> closest_numbers(int[] arr, int k, int target){

        if(target < arr[0]){
            List<Integer> li = new ArrayList<>();
            for(int i=0; i<k; i++){
                li.add(arr[i]);
            }
            return li;
        }

        else if(target > arr[arr.length-1]){
            List<Integer> li = new ArrayList<>();
           for(int j=k; j<arr.length;j++){
               li.add(arr[j]);
           }
            return li;
        }

        int index = search(arr, target);
        int count =0;
        int low =index-1;
        int high = index;

        List<Integer> ans = new ArrayList<>();
        while(low>=0 && high<arr.length && count <k){
            if(target-arr[low] <= arr[high]-target){
                ans.add(arr[low]);
                low--;
            }
            else{
                ans.add((arr[high]));
                high++;
            }
            count++;
        }

        while(low>=0 && count++<k){
            ans.add((arr[low]));
            low--;
        }

        while(high <arr.length && count++<k){
            ans.add(arr[high]);
            high++;
        }
        Collections.sort(ans);
        return ans;
    }

    public static int search(int[] arr, int target){
        int s = 0;
        int e = arr.length;

        while(s<=e){
            int mid = s +(e-s)/2 ;

            if(arr[mid] == target) return mid;

            else if (arr[mid] < target) {
                s = mid +1;
            }
            else {
                e = mid-1;
            }
        }
        return s;
    }
}
