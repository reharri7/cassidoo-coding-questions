package y2026.sept8;

/**
  * You have a backpack lock's starting position, and the code to unlock it, represented as two strings of integers.
  * In one move, you may rotate any single digit one step up or down, with 0 and 9 considered adjacent.
  * Return the minimum number of moves needed to transform the starting code into the unlock code.
*/
public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.minMoves("8051", "1199"));
    System.out.println(solution.minMoves("000", "555"));
    System.out.println(solution.minMoves("109", "990"));
  }

  public int minMoves(String start, String target) {
    int moves = 0;
    for (int i = 0; i < start.length(); i++) {
      int diff = Math.abs(start.charAt(i) - target.charAt(i));
      moves += Math.min(diff, 10 - diff);
    }
    return moves;
  }
}
