import java.util.Arrays;

public class RadixSort
{
    public static void main(String[] args) {
        int[] arr = {80, 406, 21, 655, 55, 4, 8, 91, 87, 6};
        System.out.println("Original Array- " + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("Sorted array after Radix sort- " + Arrays.toString(arr));
    }

    private static void radixSort(int[] arr)
    {
        int max = getMaxElement(arr);
        int position = 1;
        while(max/position > 0)
        {
            countingSort(arr, position);
            position *= 10;
        }
    }
    /* © Jaspreet Singh */
    private static int getMaxElement(int[] arr)
    {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++)
        {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    private static void countingSort(int[] arr, int position)
    {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[n];

        //count number of times each element appear
        for(int i = 0; i < arr.length; i++){
            count[(arr[i]/position)%10]++;
        }

        // each element stores (element at current index+element at previous index) to get the actual position of the element.//
        for(int i = 1; i < n; i++){
            count[i] = count[i] + count[i-1];
        }

        // for correct placement of the numbers start from the end.//
        for(int i = n-1; i >=0; i--)
        {
            output[count[(arr[i]/position)%10] - 1] = arr[i];
            count[(arr[i]/position)%10]--;
        }
        // Copy output array to input to the input for the next stage of counting sort.//
        for(int i = 0; i < output.length; i++){
            arr[i] = output[i];
        }
        System.out.println("Counting sort at this stage " + Arrays.toString(arr));
    }
}
