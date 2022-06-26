
import java.util.Arrays;

public class QuickSort {

    public static void main(String args[])
    {

        long init =System.currentTimeMillis();
        int array[] =  {5, 1, 45,98 , 68, 9 ,2 ,10};
        int start= 0;
        int end = array.length-1;
         sort(array, start, end) ;
        long finish =System.currentTimeMillis();

        System.out.println(finish-init);
        System.out.println(Arrays.toString(array));
//        for (int arr : array) {
//            System.out.println(arr);
//        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start;
        int j = start;
        while (i<=end){
            if(array[i]<=pivot){
                swap(array, i, j);
                j++;
            }
            i ++;
        }
        return j -1;
    }

    private static void sort(int[] array, int start, int end) {
         if (start<end){
            int boundary=  partition(array,start,end);
             sort(array, start, boundary-1);
             sort(array,boundary+1, end);
         }
    }

    public static void swap(int[] input, int index1, int index2){
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;

    }
}
