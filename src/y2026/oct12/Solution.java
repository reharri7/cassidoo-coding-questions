package y2026.oct12;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  private final Map<Integer, Integer> memo = new HashMap<>();

  static void main() {
    y2026.oct12.Solution sol = new y2026.oct12.Solution();
    sol.maxCandy(new int[]{2, 7, 9, 3, 1});
    sol.maxCandy(new int[]{5, 1, 1, 5});
    sol.maxCandy(new int[]{4});
  }

  private void maxCandy(int[] houses) {
    memo.clear();
    int ans = maxCandy(houses, 0);
    System.out.println(ans);
  }

  private int maxCandy(int[] houses, int index) {
    if (index >= houses.length) {
      return 0;
    }

    if (memo.containsKey(index)) {
      return memo.get(index);
    } else {
      int visit = houses[index] + maxCandy(houses, index + 2);
      int skip = maxCandy(houses, index + 1);
      memo.put(index, Math.max(visit, skip));
      return Math.max(visit, skip);
    }

  }
}
