package y2026.aug24;

import java.util.Arrays;

/**
 * Given an array of integers, return a new array where odd numbers come first
 * even numbers come next and zeros appear at the end. The relative order of elements
 * within each group must be preserved.
 * [0, 3, 2, 1, 4, 0, 7] -> [3, 1, 7, 2, 4, 0, 0]
*/
public class Solution {

  static void main(String[] _args) {
    int[][] arrays = {
        {0, 3, 2, 1, 4, 0, 7},
        {}
    };
    for(int[] a : arrays) {
      int[] answer = partitionArray(a);
      System.out.println(Arrays.toString(a) + " -> " + Arrays.toString(answer));
    }
  }

  static int[] partitionArray(int[] arr) {
    if (arr == null) {
      return new int[0];
    }
    int[] answer = new int[arr.length];
    int index = 0;

    for (int num : arr) {
      if (num % 2 != 0) {
        answer[index++] = num;
      }
    }
    for (int num : arr) {
      if (num != 0 && num % 2 == 0) {
        answer[index++] = num;
      }
    }
    for (int num : arr) {
      if (num == 0) {
        answer[index++] = 0;
      }
    }
    return answer;
  }
}