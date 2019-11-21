public class InsertionSort {

    public static void main(String a[])
    {
        int[] arr1 = {12,76,1,0,7,69,77,99};
        int[] arr2 = doInsertionSort(arr1);
        for(int i:arr2)
        {
            System.out.print(i);
            System.out.print(", ");
        }
    }                                                          /* © Jaspreet Singh */
    public static int[] doInsertionSort(int[] input){

        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--)
            {
                if(input[j] < input[j-1])
                {
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
}
