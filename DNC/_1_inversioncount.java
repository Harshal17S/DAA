import java.util.Arrays;


public class _1_inversioncount {

     public static void main(String[] args) {
        int []arr = {1, 9, 6, 4, 5};
        System.out.println(mergeSort(arr,0,arr.length-1));
    }

    private static int mergeAndCount(int[] arr, int l, int m, int r)
    {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, count = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                count += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return count;
    }

    private static int mergeSort(int[] arr, int l, int r)
    {
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;
            count += mergeSort(arr, l, m);
            count += mergeSort(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }
}