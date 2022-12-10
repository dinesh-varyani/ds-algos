package com.hubberspot.dsalgo.matrix;

public class SpiralMatrix {

   public static void spiralPrint(int[][] matrix, int r, int c) {
      int i;
      int k = 0; // k -> r
      int l = 0; // l -> c

      while (k < r && l < c) {
         // left to right --> column varies --> l -> c - 1, row remains constant
         for (i = l; i < c; i++) {
            System.out.print(matrix[k][i] + " ");
         }
         k++;
         // top to bottom --> row varies --> k -> r - 1, column remains constant
         for (i = k; i < r; i++) {
            System.out.print(matrix[i][c - 1] + " ");
         }
         c--;
         if (k < r) {
            // right to left --> column varies --> c - 1 -> l, row remains constant
            for (i = c - 1; i >= l; i--) {
               System.out.print(matrix[r - 1][i] + " ");
            }
            r--;
         }
         if (l < c) {
            // bottom to top --> row varies --> r - 1 -> k, column remains constant
            for (i = r - 1; i >= k; i--) {
               System.out.print(matrix[i][l] + " ");
            }
            l++;
         }
      }
   }

   public static void main(String[] args) {
      int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
      spiralPrint(matrix, matrix.length, matrix[0].length);
   }
}