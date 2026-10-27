package y2026.oct26;


// Each person at a Halloween party has exactly one costume, but they’ve been shuffled:
// costumes[i] is the index of the person who owns the costume person i is wearing.
// Return the minimum number of swaps between any two people needed to give everyone their own costume.
public class Solution {

  static void main() {
    var sol = new Solution();
    System.out.println(sol.halloweenSwap(new int[]{0, 1, 2, 3}));
    System.out.println(sol.halloweenSwap(new int[]{1, 2, 0}));
    System.out.println(sol.halloweenSwap(new int[]{4, 3, 2, 1, 0}));
    System.out.println(sol.halloweenSwap(new int[]{2, 3, 4, 0, 1}));

  }

  public int halloweenSwap(int[] costumes) {
    boolean[] visited = new boolean[costumes.length];
    int swaps = 0;

    for(int i = 0; i < costumes.length; i++) {
      if(visited[i]) continue;

      int current = i;
      int cycleLength = 0;
      while(!visited[current]) {
        visited[current] = true;
        current = costumes[current];
        cycleLength++;
      }

      swaps += cycleLength - 1;
    }
    return swaps;
  }
}
