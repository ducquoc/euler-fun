package vn.ducquoc.euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <b>//hackerrank.com/contests/projecteuler/challenges/euler021</b>
 * 
 * @author ducquoc
 */
@SuppressWarnings({ "unused" })
public class HR021 {

  public static void main(String[] args) throws Exception {
    int t, N, K, M;

    DScanner in = new DScanner();
    t = in.nextInt();

    HashMap<Integer, Long> sumUnderN = new HashMap<Integer, Long>();
    long sum = 0;
    for (int j = 1; j < 100000; j++) {
      int a = j;
      long da = sumProperDivisors(a);
      long b = da;
      long db = sumProperDivisors(b);
      if (a != b && a == db) {
        sum += a;
        sumUnderN.put(j, sum);
      } else {
        sumUnderN.put(j, sum);
      }
    }

    while (t-- > 0) {
      N = in.nextInt();
      System.out.println(sumUnderN.get(N));
    }

    if (in != null)
      in.close();
  }

  public static long sumProperDivisors(long n) {
    if (n <= 1)
      return n;

    int maxD = (int) Math.sqrt(n);
    long sum = 1;
    for (int i = 2; i <= maxD; i++) {
      if (n % i == 0) {
        sum += i;
        long d = n / i;
        if (d != i)
          sum += d;
      }
    }
    return sum;
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
