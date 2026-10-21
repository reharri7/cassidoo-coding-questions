package y2026.oct19;

import java.util.ArrayList;
import java.util.List;

// There's a ghost in your keyboard! It keeps typing weird symbols in your words.
// Given a string you typed (with the ghost), # deletes the last character and ~ duplicates it,
// if one exists. Return the final text.
public class Solution {
  List<Character> stack;

  static void main() {
    Solution solution = new Solution();
    solution.ghostWriter("ghost");
    solution.ghostWriter("a#~b");
    solution.ghostWriter("ab~c#");
    solution.ghostWriter("BBB##0~");
  }

  private void ghostWriter(String chars) {
    stack = new ArrayList<>();
    for(int i = 0; i < chars.length(); i++) {
      if(chars.charAt(i) == '#') {
        if(!stack.isEmpty()) {
          stack.removeLast();
        }
      } else if(chars.charAt(i) == '~') {
        if(!stack.isEmpty()) {
          stack.add(stack.getLast());
        }
      } else {
        stack.add(chars.charAt(i));
      }
    }
    StringBuilder sb = new StringBuilder();
    for(Character c : stack) {
      sb.append(c);
    }
    System.out.println(sb);
  }
}
