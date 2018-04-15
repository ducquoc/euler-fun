package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler030</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR030 {

  public static void main(String args[]) {
    int t, N, K, M;
    DScanner in = new DScanner(System.in);

    t = in.nextInt();
    long n = (long) (t * Math.pow(9, t));
    long sum = 0;
    for (long i = 2; i <= n; i++) {
      long digitSum = getDigitSum(i, t);
      if (i == digitSum) {
        sum += digitSum;
      }
    }
    System.out.println(sum);
  }

  public static long getDigitSum(long num, int pow) {
    long digitSum = 0;
    while (num != 0) {
      int digit = (int) num % 10;
      digitSum += (long) Math.pow(digit, pow);
      num /= 10;
    }
    return digitSum;
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

    public String next() {// no nextLine() : prefer br.readLine()
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
      return Integer.valueOf(next());
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

    //long nextLong() { return Long.valueOf(next()); }
    //double nextDouble() { return Double.valueOf(next()); }
    //String nextLine() throws IOException { return br.readLine(); }
  }

}
