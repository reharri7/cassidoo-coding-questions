package y2026.sept28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
  // Given an array of daily temperatures and a number drop, return an array where
  // each element is how many days you'd wait until it's at least drop degrees
  // colder than that day. If that never happens, put 0.

  public static void main() {
    Solution sol = new Solution();

    sol.firstFrost(List.of(70, 68, 72, 60, 65, 55), 5).forEach(System.out::print);
    System.out.println();
    sol.firstFrost(List.of(50, 49, 48), 5).forEach(System.out::print);
    System.out.println();
    sol.firstFrost(List.of(40, 30, 45, 20), 10).forEach(System.out::print);
    System.out.println();
    sol.firstFrost(List.of(70, 68, 64), 5).forEach(System.out::print);
    System.out.println();
    sol.firstFrost(List.of(70, 60, 65, 64), 5).forEach(System.out::print);
    System.out.println();
  }

  public List<Integer> firstFrost(List<Integer> temps, int drop) {
    List<Integer> stack = new ArrayList<>();
    List<Integer> ans = new ArrayList<>(Collections.nCopies(temps.size(), 0));
    for(int i = temps.size() - 1; i >= 0; i--) {
      int target = temps.get(i) - drop;

      int lo = 0, hi = stack.size() - 1, found = -1;
      while(lo <= hi) {
        int mid = (lo + hi) / 2;
        if(temps.get(stack.get(mid)) <= target) {
          found = mid;
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      }
      if(found != -1) {
        ans.set(i, stack.get(found) - i);
      }

      while(!stack.isEmpty() && temps.get(stack.getLast()) >= temps.get(i)) {
        stack.removeLast();
      }
      stack.add(i);
    }
    return ans;
  }
}
