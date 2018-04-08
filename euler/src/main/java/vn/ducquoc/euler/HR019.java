package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler019</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR019 {

  public static String[] day = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
  public static String[] month = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

  public static void main(String[] args) throws NumberFormatException, IOException {
    int t, N, K, M;

    DScanner in = new DScanner();
    t = in.nextInt();

    while (t-- > 0) {
      {
        long y1 = in.nextLong();
        int m1 = in.nextInt();
        int d1 = in.nextInt();
        long y2 = in.nextLong();
        int m2 = in.nextInt();
        int d2 = in.nextInt();
        long sundayCount = 0;
        int dow = getDayOfWeek(y1, m1, d1);

        while (y1 < y2) {
          while (m1 <= 12) {
            int numberOfDaysInMonth = getDaysInMonth(y1, m1);
            while (d1 <= numberOfDaysInMonth) {
              if (day[dow].equals("Sunday") && d1 == 1) {
                // System.out.println(sundayCount + " " + y1 + " " + m1 + " " +
                // d1 + " " + day[dow]);
                sundayCount += 1;
              }
              if (dow == 6)
                dow = 0;
              else
                dow += 1;
              d1 += 1;
            }
            d1 = 1;
            m1 += 1;
          }
          m1 = 1;
          y1 += 1;
        }
        if (y1 == y2) {
          while (m1 < m2) {
            int numberOfDaysInMonth = getDaysInMonth(y1, m1);
            while (d1 <= numberOfDaysInMonth) {
              if (day[dow].equals("Sunday") && d1 == 1) {
                // System.out.println(sundayCount + " " + y1 + " " + m1 + " " +
                // d1 + " " + day[dow]);
                sundayCount += 1;
              }
              if (dow == 6)
                dow = 0;
              else
                dow += 1;
              d1 += 1;
            }
            d1 = 1;
            m1 += 1;
          }
          if (m1 == m2) {
            while (d1 <= d2) {
              if (day[dow].equals("Sunday") && d1 == 1) {
                sundayCount += 1;
              }
              if (dow == 6)
                dow = 0;
              else
                dow += 1;
              d1 += 1;
            }
          }
        }
        System.out.println(sundayCount);
      }
    }

    if (in != null)
      in.close();
  }

  public static int getDaysInMonth(long y1, int m1) {
    int numberOfDaysInMonth = 0;
    if (month[m1].equals("September") || month[m1].equals("April")
        || month[m1].equals("June") || month[m1].equals("November"))
      numberOfDaysInMonth = 30;
    else if (month[m1].equals("February")) {
      if (isLeapYear(y1))
        numberOfDaysInMonth = 29;
      else
        numberOfDaysInMonth = 28;
    } else
      numberOfDaysInMonth = 31;

    return numberOfDaysInMonth;
  }

  public static int getDayOfWeek(long year, int month, int day) {
    if (month == 1) {
      month = 13;
      year -= 1;
    }
    if (month == 2) {
      month = 14;
      year -= 1;
    }
    long j = year / 100;
    long k = year % 100;
    long dow = (day + (26 * (month + 1)) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;
    if (dow < 0)
      dow += 7;

    return (int) dow;
  }

  public static boolean isLeapYear(long year) {
    if (year % 4 != 0)
      return false;
    else {
      if (year % 100 != 0)
        return true;
      else {
        if (year % 400 == 0)
          return true;
        else
          return false;
      }
    }
  }

  public static class DScanner {// Dummy Scanner not DqScanner
    java.io.BufferedReader br;
    java.util.StringTokenizer st;

    public DScanner() {
      br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
    }

    public DScanner(java.io.InputStream is) {// file/resource
      br = new java.io.BufferedReader(new java.io.InputStreamReader(
          new java.io.DataInputStream(is)));
    }

    public String nextToken() {// no nextLine() : prefer br.readLine()
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new java.util.StringTokenizer(br.readLine());
        } catch (java.io.IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.valueOf(nextToken());
    }

    public void close() {
      if (br != null) {
        try {
          br.close();
        } catch (java.io.IOException e) {
          e.printStackTrace();
        }
      }
    }

    long nextLong() {
      return Long.valueOf(nextToken());
    }

    double nextDouble() {
      return Double.valueOf(nextToken());
    }

  }

}
