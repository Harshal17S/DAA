import java.util.HashSet;

/**
 * _8_frquency
 */
public class _8_frquency {

   
    public static void main(String[] args) {
        freq(new int[]{2, 2, 2, 4, 4, 4, 5, 5, 6, 8, 8, 9});
    }

    public static void freq(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for(int elt=0; elt<arr.length; elt++){
            hs.add(arr[elt]);
        }

        for(int elt: hs){
            int first = binarySearch(arr, elt, true);
            int last = binarySearch(arr, elt, false);
            System.out.println(elt + " : "+ (last-first+1));
        }
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