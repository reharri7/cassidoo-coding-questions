package y2026.aug31;

/**
 * Given an integer n representing the number of steps in a staircase, return
 * the number of distinct ways to reach the top when each move can climb either
 * one or two steps at atime.
 */
public class Solution {

  static void main(String[] _args) {
    int[] staircases = {2, 4, 10};

    for (int steps : staircases) {
      System.out.println(climbStairs(steps));
    }
  }

  static int climbStairs(int n) {
    int previous = 1;
    int current = 1;

    for (int step = 2; step <= n; step++) {
      int next = previous + current;
      previous = current;
      current = next;
    }

    return current;
  }
}
