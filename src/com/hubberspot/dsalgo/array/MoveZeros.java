package com.hubberspot.dsalgo.array;

public class MoveZeros {

   public void printArray(int[] arr) {
      int n = arr.length;
      for (int i = 0; i < n; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

   public void arrayDemo() {
      int[] arr = { 8, 1, 0, 2, 1, 0, 3 };
      printArray(arr);
      moveZeros(arr, arr.length);
      printArray(arr);
   }

   public void moveZeros(int[] arr, int n) {
      int j = 0; // focus on zeroth elements
      for (int i = 0; i < n; i++) { // i will focus non zero elements
         if (arr[i] != 0 && arr[j] == 0) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
         }
         if (arr[j] != 0) {
            j++;
         }
      }
   }

   public static void main(String[] args) {
      MoveZeros arrUtil = new MoveZeros();
      arrUtil.arrayDemo();
   }

}