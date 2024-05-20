/**
 * _4_noof1's
 */
public class _4_noofone {

    public static void main(String[] args) {
     
                int []arr = {0,0,0,0,1,1,1,1};
                int ans = arr.length - binarySearch(arr);
                System.out.println(ans);
            }
            public static int binarySearch(int []nums){
                int s=0;
                int e= nums.length-1;
                int ans =nums.length; 
        
                while(s<=e){
                    int mid = s +(e-s)/2;
                    if(nums[mid] !=1){
                        s=mid+1;
                    }
                    else{
                        ans = mid;
                        e = mid-1;
                    }
                }
                return ans;
            }
}