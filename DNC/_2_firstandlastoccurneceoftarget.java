import java.util.HashSet;

/**
 * _2_firstandlastoccurneceoftarget
 */
public class _2_firstandlastoccurneceoftarget {

    public static void main(String[] args) {
       int[]arr={2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
       int target=5;
        int first = binarySearch(arr, target, true);
            
        int last = binarySearch(arr, target, false);

        System.out.println(first+" "+last);
    }



    public static int binarySearch(int[] nums, int target, boolean find) {
        int s = 0;
        int e = nums.length - 1;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (target < nums[mid]) {
                e = mid - 1;
            } else if (target > nums[mid]) {
                s = mid + 1;
            } else {
                ans = mid;
                if (find) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
        }
        return ans;
    }

}