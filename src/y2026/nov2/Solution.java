package y2026.nov2;

// Given a chronological log of local "HH:MM" timestamps from the night daylight saving time ends,
// return the actual number of minutes between the first and last entries.
// The log contains a consecutive pair that reveals the clock’s one-hour rollback.
public class Solution {

  public static void main() {
    Solution solution = new Solution();
    solution.elapsedMinutes(new String[]{"00:50", "01:10", "01:50", "01:10", "02:10"});
    solution.elapsedMinutes(new String[]{"01:55", "01:05", "01:25", "01:40"});
  }

  public void elapsedMinutes(String[] times) {
    int ans = 0;

    int first = toMinutes(times[0]);
    int last = toMinutes(times[times.length - 1]);

    ans = last - first + 60; // We are assuming just one instance of clock rollback

    System.out.println(ans);
  }

  private int toMinutes(String time) {
    return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
  }
}
