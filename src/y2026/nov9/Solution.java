package y2026.nov9;

// Given rounds in a board game, where rounds[r][p] is the points player p earned in round r,
// find the earliest round from which the eventual winner is the sole leader at the end of every remaining round.
// Return the round number (1-based), or -1 if the final score is tied.
public class Solution {

  static void main() {
    Solution solution = new Solution();
    solution.comebackRound(new int[][]{{5, 3, 2}, {0, 5, 2}, {4, 2, 2}, {1, 3, 0}});
    solution.comebackRound(new int[][]{{4, 2}, {1, 3}, {2, 1}});
    solution.comebackRound(new int[][]{{4, 2}, {1, 3}});
  }

  void comebackRound(int[][] rounds) {
    int lastLeaderChange = -1;
    int leaderIndex = -1;
    int[] scores = new int[rounds[0].length];

    for (int i = 0; i < rounds.length; i++) {
      int bestScore = Integer.MIN_VALUE;
      int bestPlayer = -1;
      boolean tied = false;

      // Sum up the points for each player in the current round
      for (int p = 0; p < rounds[i].length; p++) {
        scores[p] += rounds[i][p];
        if (scores[p] > bestScore) {
          bestScore = scores[p];
          bestPlayer = p;
          tied = false;
        } else if (scores[p] == bestScore) {
          tied = true;
        }
      }

      if (tied || bestPlayer != leaderIndex) { // lead change
        leaderIndex = tied ? -1 : bestPlayer;
        lastLeaderChange = i + 1;
      }
    }

    System.out.println(leaderIndex == -1 ? -1 : lastLeaderChange);
  }
}
