package y2026.nov16;

import java.util.ArrayList;
import java.util.List;

// A kangaroo word contains a shorter synonym (its "joey") whose letters appear in order,
// but not necessarily consecutively. Given a lowercase word and a list of its synonyms (non-empty),
// return all the joeys in the list's original order.

public class Solution {

  static void main() {
    Solution solution = new Solution();
    solution.findJoeys("blossom", List.of("flower", "bloom"));
    solution.findJoeys("chocolate", List.of("cocoa", "candy"));
    solution.findJoeys("cat", List.of("feline"));
  }

  void findJoeys(String kangaroo, List<String> synonyms) {
    List<String> joeys = new ArrayList<>();

    for (String synonym : synonyms) {
      if (isJoey(kangaroo, synonym)) {
        joeys.add(synonym);
      }
    }

    joeys.forEach(System.out::println);
  }

  boolean isJoey(String word, String synonym) {
    if (synonym.length() >= word.length()) {
      return false;
    }

    int next = 0;

    for (int i = 0; i < word.length() && next < synonym.length(); i++) {
      if (word.charAt(i) == synonym.charAt(next)) {
        next++;
      }
    }

    return next == synonym.length();
  }
}
