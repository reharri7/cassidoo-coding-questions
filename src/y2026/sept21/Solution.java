package y2026.sept21;

import java.util.Arrays;
import java.util.Objects;

// Given a year and a month, return an array containing every day in that month that
// falls on a sunday. Return the date in YYYY-MM-DD format.
public class Solution {
  public String[] getSundays(int year, int month) {
    String[] sundays = new String[daysInMonth(year, month)];
    for(int i = 1; i < daysInMonth(year, month); i++) {
      if(isSunday(year, month, i)) {
        sundays[i - 1] = String.format("%d-%02d-%02d", year, month, i);
      }
    }
    return Arrays.stream(sundays).filter(Objects::nonNull).toArray(String[]::new);
  }

  private boolean isLeapYear(int year) {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
  }

  private int daysInMonth(int year, int month) {
    if (month == 2) {
      return isLeapYear(year) ? 29 : 28;
    }
    return new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}[month - 1];
  }

  private boolean isSunday(int year, int month, int day) {
    int lastTwoDigitsOfYear = year % 100;
    int ans = lastTwoDigitsOfYear / 4;
    ans += getMonthCode(month, year);
    ans += day;
    ans += getCenturyCode(year);
    ans += lastTwoDigitsOfYear;
    ans %= 7;
    return ans == 1;
  }

  private int getMonthCode(int month, int year) {
    if(isLeapYear(year)) {
      if(month == 1 || month == 2) {
        return month == 1 ? 0 : 3;
      }
    }
    // Jan 1 or 0 in leap year
    // Feb 4 or 3 in leap year
    // march 4
    // april 0
    // may 2
    // jun 5
    // jul 0
    // aug 3
    // sep 6
    // oct 1
    // nov 4
    // dec 6
    return new int[] {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6}[month - 1];
  }

  private int getCenturyCode(int year) {
    // For a Gregorian date, add 0 for 1900's, 6 for 2000's, 4 for 1700's, 2 for 1800's; for other years, add or subtract multiples of 400.
    //For a Julian date, add 1 for 1700's, and 1 for every additional century you go back.
    int century = year / 100;
    int centuryMod = century % 4;
    return (6 - (centuryMod * 2)) % 7;
  }

  private void printSundays(String[] sundays) {
    for (String sunday : sundays) {
      System.out.println(sunday);
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.printSundays(solution.getSundays(2026, 9));
    solution.printSundays(solution.getSundays(2024, 2));
  }
}
