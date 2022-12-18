package com.hubberspot.dsalgo.array;

public class MergeSortedArrays {

   public int[] merge(int[] arr1, int[] arr2, int n, int m) {
      int[] result = new int[n + m];
      int i = 0; // traverse arr1
      int j = 0; // traverse arr2
      int k = 0; // traverse result

      while (i < n && j < m) { // boundary conditions
         if (arr1[i] < arr2[j]) { // if arr1 element at i is less than arr2 element at j
            result[k] = arr1[i]; // storing arr1 element into result
            i++;
         } else {
            result[k] = arr2[j]; // storing arr2 element into result
            j++;
         }
         k++;
      }
      // either arr1 got exhausted or arr2 got exhausted
      while (i < n) { // arr2 got exhausted
         result[k] = arr1[i]; // storing arr1 element into result
         i++;
         k++;
      }

      while (j < m) { // arr1 got exhausted
         result[k] = arr2[j]; // storing arr2 element into result
         j++;
         k++;
      }

      return result;

   }

   public void printArray(int[] arr) {
      int n = arr.length;
      for (int i = 0; i < n; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

   public static void main(String[] args) {
      MergeSortedArrays msa = new MergeSortedArrays();
      int[] arr1 = { 0, 1, 8, 10 };
      int[] arr2 = { 2, 4, 11, 15, 20 };
      msa.printArray(arr1);
      msa.printArray(arr2);

      int[] result = msa.merge(arr1, arr2, arr1.length, arr2.length);
      msa.printArray(result);
   }

}