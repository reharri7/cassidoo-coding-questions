package y2026.sept14;

import java.util.Arrays;
import java.util.List;

/**
 * Given a sentence, return the longest word whose letters appear in alphabetical order.
 */
public class Solution {
  static void main() {
    System.out.println(longestSorted("The autumn leaves almost glow."));
    System.out.println(longestSorted("A cool sheep sleeps."));
  }

  static String longestSorted(String sentence) {
    List<String> words = Arrays.stream(sentence.split("[^a-zA-Z]+")).toList();
    words = words.stream().filter(Solution::isSorted).toList();


    String longestWord = "";
    for (String word : words) {
      if (word.length() > longestWord.length()) {
        longestWord = word;
      }
    }

    return longestWord;
  }

  private static boolean isSorted(String word) {
    if(word.length() <= 1) return false;
    for (int i = 0; i < word.length() - 1; i++) {
      if (word.charAt(i) > word.charAt(i + 1)) {
        return false;
      }
    }
    return true;
  }
}
