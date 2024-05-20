/**
 * _3_smallestmissingno
 */
public class _3_smallestmissingno {

    public static void main(String[] args) {
        System.out.println(smallestMissing(new int[]{0,1,2,4,5}));
        System.out.println(smallestMissing(new int[]{0,1,2,3,4,5}));
    }

    public static int smallestMissing(int []arr){
        int s=0;
        int e=arr.length-1;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(arr[mid]!=mid){
                e = mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return s;
    }
}