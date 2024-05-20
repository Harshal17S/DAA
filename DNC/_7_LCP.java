/**
 * _7_LCP
 */
public class _7_LCP {

    public static void main(String[] args) {
        String [] arr = {"Technology", "Technique","Technique","Technocrat"};
        System.out.println(divide(arr,0,arr.length-1));
    }

    public static String lcp(String s1, String s2){
        String result = "";
        int i=0;
        int j=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)!=s2.charAt(j)){
                break;
            }
            result+=s1.charAt(i);
            i++;
            j++;
        }
        return result;
    }

    public static String divide(String []arr, int low, int high){
        if(low==high){
            return arr[low];
        }

        if(low<high){
            int mid = low +(high-low)/2;

            String left = divide(arr,low,mid);
            String right = divide(arr,mid+1,high);

            return lcp(left,right);
        }
        return null;
    }

}