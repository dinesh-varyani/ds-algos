package com.hubberspot.dsalgo.sorting;

public class Sort012 {

   public void printArray(int[] arr) {
      int n = arr.length;
      for (int i = 0; i < n; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

   public void threeNumberSort(int[] arr) {
      // 3 pointer technique
      int i = 0; // traverse the array and place 1's in the middle region
      int j = 0; // place 0's at the starting range
      int k = arr.length - 1; // place 2's at the end
      while (i <= k) {
         if (arr[i] == 0) {
            swap(arr, i, j);
            j++;
            i++;
         } else if (arr[i] == 1) {
            i++;
         } else if (arr[i] == 2) {
            swap(arr, i, k);
            k--;
         }
      }
   }

   private static void swap(int[] arr, int first, int second) {
      int temp = arr[first];
      arr[first] = arr[second];
      arr[second] = temp;
   }

   public static void main(String[] args) {
      int[] arr = new int[] { 2, 0, 0, 1, 0, 2, 0, 1, 0, 2, 2, 0 };
      Sort012 st = new Sort012();
      st.printArray(arr);
      st.threeNumberSort(arr);
      st.printArray(arr);
   }

}